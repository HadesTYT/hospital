package com.aaa.service.Impl;

import com.aaa.entity.Upplier;
import com.aaa.mapper.UpplierMapper;
import com.aaa.service.UpplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UpplierServiceImpl implements UpplierService {
    @Resource
    private UpplierMapper UpplierMapper;
    @Override
    public List<Upplier> findAllUpplier(Upplier upplier) {
        return UpplierMapper.findAllUpplier(upplier);
    }

    @Override
    public int deleteUpplier(Integer upplierId) {
        return UpplierMapper.deleteUpplier(upplierId);
    }

    @Override
    public int addUpplier(Upplier upplier) {
        return UpplierMapper.addUpplier(upplier);
    }

    @Override
    public int editUpplier(Upplier upplier) {
        return UpplierMapper.editUpplier(upplier);
    }
}
