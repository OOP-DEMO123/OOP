/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.poly.entity.NguoiDung;
import com.poly.utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diemp
 */
public class NguoiDungDAO extends DADAO<NguoiDung, String> {

    @Override
    public void insert(NguoiDung entity) {
        String sql = "INSERT INTO Users(username, password, image, address, email) VALUES (?,?,?,?,?)";
        XJdbc.update(sql,
                entity.getTenND(),
                entity.getMatKhau(),
                entity.getHinh(),
                entity.getDiaChi(),
                entity.getEmail());
       
    }

    @Override
    public void update(NguoiDung entity) {
        String sql = "UPDATE Users SET  password=?, image=?, address=?, email=? WHERE username=?";
         XJdbc.update(sql,
                entity.getMatKhau(),
                entity.getHinh(),
                entity.getDiaChi(),
                entity.getEmail(),
                entity.getTenND());
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM Users WHERE username=?";
        XJdbc.update(sql, id);
    }

    @Override
    public NguoiDung selectById(String id) {
        String sql = "SELECT * FROM users WHERE username=?";
        List<NguoiDung> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<NguoiDung> selectNotInCoure(String keyword){
        String sql = "SELECT * FROM users WHERE username like ?";
        return selectBySql(sql, "%"+ keyword +"%");
    }
    
    public List<NguoiDung> OderByDesc() {
        String sql = "SELECT * FROM users ORDER BY username DESC ";
        return selectBySql(sql);
    }
    
    public List<NguoiDung> OderByAsc () {
        String sql = "SELECT * FROM users ORDER BY username ASC";
        return selectBySql(sql);
    }
    @Override
    public List<NguoiDung> selectAll() {
        String sql = "SELECT * FROM users";
        return selectBySql(sql);
    }

    public List<NguoiDung> selectBySearch(String id) {
        String sql = "SELECT * FROM users WHERE username like ?";
        return selectBySql(sql, "%" + id +"%");
    }
    
    @Override
    public List<NguoiDung> selectBySql(String sql, Object... args) {
        List<NguoiDung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NguoiDung entity = new NguoiDung();
                    entity.setTenND(rs.getString("username"));
                    entity.setMatKhau(rs.getString("password"));
                    entity.setHinh(rs.getString("image"));
                    entity.setEmail(rs.getString("email"));
                    entity.setDiaChi(rs.getString("address"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    
    

}
