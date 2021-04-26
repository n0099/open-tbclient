package d.a.i0.b1.j;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: e  reason: collision with root package name */
    public ConstrainImageLayout.c f48226e;

    /* renamed from: d.a.i0.b1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1028a implements ConstrainImageLayout.c {
        public C1028a(a aVar) {
        }

        @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.c
        public void a(TbImageView tbImageView, int i2, int i3) {
            tbImageView.setRadiusById(R.string.J_X05);
            tbImageView.A();
            tbImageView.setDrawCorner(true);
            tbImageView.setConrers(0);
            if (i3 == 1) {
                tbImageView.setConrers(15);
            } else if (i3 > 1) {
                if (i2 == 0) {
                    tbImageView.setConrers(5);
                } else if (i2 == i3 - 1) {
                    tbImageView.setConrers(10);
                }
            }
        }
    }

    public a(int i2) {
        super(i2);
        this.f48226e = new C1028a(this);
    }

    @Override // d.a.i0.b1.j.f, d.a.i0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2, int i3) {
        if (list.size() < this.f48228b) {
            list.size();
        }
        constrainImageLayout.setTbImageViewConfiguration(this.f48226e);
        return super.a(constrainImageLayout, list, i2, i3);
    }
}
