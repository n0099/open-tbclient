package d.b.i0.b1.j;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: e  reason: collision with root package name */
    public ConstrainImageLayout.c f50662e;

    /* renamed from: d.b.i0.b1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1089a implements ConstrainImageLayout.c {
        public C1089a(a aVar) {
        }

        @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.c
        public void a(TbImageView tbImageView, int i, int i2) {
            tbImageView.setRadiusById(R.string.J_X05);
            tbImageView.B();
            tbImageView.setDrawCorner(true);
            tbImageView.setConrers(0);
            if (i2 == 1) {
                tbImageView.setConrers(15);
            } else if (i2 > 1) {
                if (i == 0) {
                    tbImageView.setConrers(5);
                } else if (i == i2 - 1) {
                    tbImageView.setConrers(10);
                }
            }
        }
    }

    public a(int i) {
        super(i);
        this.f50662e = new C1089a(this);
    }

    @Override // d.b.i0.b1.j.f, d.b.i0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        if (list.size() < this.f50664b) {
            list.size();
        }
        constrainImageLayout.setTbImageViewConfiguration(this.f50662e);
        return super.a(constrainImageLayout, list, i, i2);
    }
}
