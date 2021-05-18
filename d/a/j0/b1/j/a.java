package d.a.j0.b1.j;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: e  reason: collision with root package name */
    public ConstrainImageLayout.c f49054e;

    /* renamed from: d.a.j0.b1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1104a implements ConstrainImageLayout.c {
        public C1104a(a aVar) {
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
        this.f49054e = new C1104a(this);
    }

    @Override // d.a.j0.b1.j.f, d.a.j0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2, int i3) {
        if (list.size() < this.f49056b) {
            list.size();
        }
        constrainImageLayout.setTbImageViewConfiguration(this.f49054e);
        return super.a(constrainImageLayout, list, i2, i3);
    }
}
