package com.wu.oa.biz;

import com.wu.oa.entity.ClaimVoucher;
import com.wu.oa.entity.ClaimVoucherItem;
import com.wu.oa.entity.DealRecord;

import java.util.List;

/**
 * 报销单业务接口
 */
public interface ClaimVoucherBiz {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(Integer id);
    List<ClaimVoucherItem> getItems(Integer cvid);
    List<DealRecord> getRecords(Integer cvid);

    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);

    void update(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items);
    void submit(Integer id);
    void deal(DealRecord dealRecord);

}
