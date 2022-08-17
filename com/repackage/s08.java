package com.repackage;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes7.dex */
public interface s08 {
    AbsVideoPbFragment B();

    PbModel.h C0();

    PbModel K();

    AbsPbActivity P();

    void finish();

    TbPageContext getPageContext();

    PbFragment l1();

    void registerListener(MessageListener<?> messageListener);
}
