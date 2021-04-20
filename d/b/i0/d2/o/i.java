package d.b.i0.d2.o;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
/* loaded from: classes3.dex */
public interface i {
    VideoPbFragment I();

    PbModel L();

    PbActivity P();

    void finish();

    TbPageContext getPageContext();

    PbModel.g r();

    void registerListener(MessageListener<?> messageListener);

    PbFragment y0();
}
