package d.a.o0.e2.o;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
/* loaded from: classes5.dex */
public interface i {
    PbModel A();

    PbActivity B();

    PbFragment C0();

    PbModel.g Y();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    VideoPbFragment x();
}
