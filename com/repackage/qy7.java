package com.repackage;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes7.dex */
public interface qy7 {
    AbsVideoPbFragment B();

    PbModel.h D0();

    PbModel F();

    AbsPbActivity N();

    void finish();

    TbPageContext getPageContext();

    PbFragment m1();

    void registerListener(MessageListener<?> messageListener);
}
