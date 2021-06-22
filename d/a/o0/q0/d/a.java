package d.a.o0.q0.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.r.s.a;
import d.a.o0.q0.b.e;
/* loaded from: classes4.dex */
public class a extends d.a.o0.z.b<d.a.o0.q0.c.a> {
    public final ImageView m;
    public final TextView n;
    public int o;

    /* renamed from: d.a.o0.q0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1539a implements a.e {
        public C1539a(a aVar) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            e.a();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(a aVar) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.o = 3;
        this.m = (ImageView) m().findViewById(R.id.history_delete);
        this.n = (TextView) m().findViewById(R.id.history_title);
        this.m.setOnClickListener(this);
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.forum_search_history_header;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.o == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_search_history_del);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0110);
        this.o = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.m) {
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f67284f.getPageActivity());
            aVar.setTitle(R.string.confirm_delete_all_history);
            aVar.setCanceledOnTouchOutside(true);
            aVar.setPositiveButton(R.string.confirm, new C1539a(this));
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(this.f67284f);
            aVar.show();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(d.a.o0.q0.c.a aVar) {
    }
}
