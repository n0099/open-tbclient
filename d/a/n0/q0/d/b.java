package d.a.n0.q0.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.q0.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends d.a.n0.z.b<d.a.n0.q0.c.a> {
    public WrapLineLayout m;
    public List<a> n;
    public int o;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f61983a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61984b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61985c;

        /* renamed from: d.a.n0.q0.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnLongClickListenerC1536a implements View.OnLongClickListener {
            public View$OnLongClickListenerC1536a(b bVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                for (a aVar : b.this.n) {
                    if (aVar != null && aVar.b() != view) {
                        aVar.d(false);
                    }
                }
                a.this.d(true);
                return true;
            }
        }

        /* renamed from: d.a.n0.q0.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1537b implements View.OnClickListener {
            public View$OnClickListenerC1537b(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f61984b.getText() == null || StringUtils.isNull(a.this.f61984b.getText().toString())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, a.this.f61984b.getText().toString()));
            }
        }

        /* loaded from: classes4.dex */
        public class c implements View.OnClickListener {
            public c(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f61984b.getText() == null) {
                    return;
                }
                e.b(a.this.f61984b.getText().toString());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
            }
        }

        public a() {
            View inflate = LayoutInflater.from(b.this.k().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.f61983a = inflate;
            this.f61984b = (TextView) inflate.findViewById(R.id.content);
            this.f61985c = (ImageView) this.f61983a.findViewById(R.id.delete);
            c();
            this.f61984b.setOnLongClickListener(new View$OnLongClickListenerC1536a(b.this));
            this.f61984b.setOnClickListener(new View$OnClickListenerC1537b(b.this));
            this.f61985c.setOnClickListener(new c(b.this));
        }

        public View b() {
            return this.f61983a;
        }

        public void c() {
            SkinManager.setViewTextColor(this.f61984b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f61984b, R.drawable.search_history_item_bg);
            SkinManager.setImageResource(this.f61985c, R.drawable.del_search_btn);
        }

        public void d(boolean z) {
            if (z) {
                this.f61985c.setVisibility(0);
                SkinManager.setImageResource(this.f61985c, R.drawable.del_search_btn);
                return;
            }
            this.f61985c.setVisibility(4);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = new ArrayList();
        this.o = 3;
        this.m = (WrapLineLayout) m();
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.forum_search_history_info;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.o == i2) {
            return;
        }
        for (a aVar : this.n) {
            if (aVar != null) {
                aVar.c();
            }
        }
        this.o = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final a u() {
        return new a();
    }

    public final void v(int i2) {
        int size = this.n.size();
        if (size == i2) {
            return;
        }
        int i3 = 0;
        if (size < i2) {
            int i4 = i2 - size;
            while (i3 < i4) {
                a u = u();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds2);
                marginLayoutParams.topMargin = g2;
                marginLayoutParams.leftMargin = g2;
                this.m.addView(u.b(), marginLayoutParams);
                this.n.add(u);
                i3++;
            }
        } else if (i2 == 0) {
            this.m.removeAllViews();
            this.n.clear();
        } else if (size > i2) {
            int i5 = size - i2;
            while (i3 < i5) {
                this.m.removeView(this.n.get(i3).b());
                this.n.remove(i3);
                i3++;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: w */
    public void n(d.a.n0.q0.c.a aVar) {
        if (aVar == null || ListUtils.isEmpty(aVar.c())) {
            return;
        }
        v(aVar.c().size());
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar2 = this.n.get(i2);
            if (aVar2 != null) {
                aVar2.d(false);
                aVar2.f61984b.setText(aVar.c().get(i2));
            }
        }
        o(this.f67159f, TbadkCoreApplication.getInst().getSkinType());
    }
}
