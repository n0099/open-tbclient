package d.b.j0.d2.k.g.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends d.b.c.j.e.a<d.b.j0.d2.k.g.f.a, a> {

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54921a;

        /* renamed from: b  reason: collision with root package name */
        public int f54922b;

        public a(View view) {
            super(view);
            this.f54922b = 3;
            this.f54921a = (TextView) view.findViewById(R.id.no_reply_list_view);
        }

        public void b() {
            if (this.f54922b != TbadkApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.f54921a, R.color.CAM_X0109);
            }
            this.f54922b = TbadkApplication.getInst().getSkinType();
        }
    }

    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public a R(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.f43095e).inflate(R.layout.sub_pb_no_reply_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.d2.k.g.f.a aVar, a aVar2) {
        aVar2.b();
        return aVar2.a();
    }
}
