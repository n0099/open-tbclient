package com.repackage;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes6.dex */
public interface pw7 {
    PbModel.h V();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    AbsVideoPbFragment s();

    PbModel v();

    AbsPbActivity w();

    PbFragment z0();
}
