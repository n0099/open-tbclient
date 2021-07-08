package d.a.p0.h2.o;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
/* loaded from: classes8.dex */
public interface b {
    PbFragment C0();

    PbModel.g Y();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    VideoPbFragment v();

    PbModel y();

    PbActivity z();
}
