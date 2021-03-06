package cn.easy.xinjing.service;

import java.util.Map;
import java.util.List;

import cn.easy.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.easy.base.bean.PageBean;
import cn.easy.xinjing.domain.GameEfs;
import cn.easy.xinjing.repository.GameEfsDao;

@Component
public class GameEfsService extends BaseService<GameEfs> {
    @Autowired
    private GameEfsDao	gameEfsDao;

    public Page<GameEfs> search(Map<String, Object> searchParams, PageBean pageBean) {
        return gameEfsDao.findAll(spec(searchParams), pageBean.toPageRequest(new Sort(Direction.DESC, "createdAt")));
    }

    public List<GameEfs> search(Map<String, Object> searchParams, Sort... sort) {
        return gameEfsDao.findAll(spec(searchParams), sort == null || sort.length == 0  ? new Sort(Direction.DESC, "createdAt") : sort[0]);
    }

    public List<GameEfs> search(Map<String, Object> searchParams) {
        return gameEfsDao.findAll(spec(searchParams));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(String id) {
        gameEfsDao.delete(id);
    }

    public GameEfs getOne(String id) {
        return gameEfsDao.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public GameEfs save(GameEfs gameEfs) {
        return gameEfsDao.save(gameEfs);
    }

}


