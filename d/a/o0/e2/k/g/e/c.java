package d.a.o0.e2.k.g.e;

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
/* loaded from: classes5.dex */
public class c extends d.a.c.k.e.a<d.a.o0.e2.k.g.f.a, a> {

    /* loaded from: classes5.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57468a;

        /* renamed from: b  reason: collision with root package name */
        public int f57469b;

        public a(View view) {
            super(view);
            this.f57469b = 3;
            this.f57468a = (TextView) view.findViewById(R.id.no_reply_list_view);
        }

        public void b() {
            if (this.f57469b != TbadkApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.f57468a, R.color.CAM_X0109);
            }
            this.f57469b = TbadkApplication.getInst().getSkinType();
        }
    }

    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public a Q(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.f43012e).inflate(R.layout.sub_pb_no_reply_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.e2.k.g.f.a aVar, a aVar2) {
        aVar2.b();
        return aVar2.a();
    }
}
