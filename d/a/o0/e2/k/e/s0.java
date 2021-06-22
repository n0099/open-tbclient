package d.a.o0.e2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbVideoDetailBrowseModeEmotionHolder;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class s0 extends o<d.a.o0.e2.h.q, PbVideoDetailBrowseModeEmotionHolder> {
    public View.OnClickListener s;

    public s0(d.a.o0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbVideoDetailBrowseModeEmotionHolder Q(ViewGroup viewGroup) {
        View view = LayoutInflater.from(this.f43012e).inflate(R.layout.video_detail_pb_browse_mode_emotion, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        return new PbVideoDetailBrowseModeEmotionHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public void Y(int i2, ViewGroup viewGroup, PbVideoDetailBrowseModeEmotionHolder pbVideoDetailBrowseModeEmotionHolder, d.a.o0.e2.h.q qVar) {
        super.Y(i2, viewGroup, pbVideoDetailBrowseModeEmotionHolder, qVar);
        if (pbVideoDetailBrowseModeEmotionHolder != null) {
            pbVideoDetailBrowseModeEmotionHolder.b();
            pbVideoDetailBrowseModeEmotionHolder.c(this.s);
        }
    }

    public final void j0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
