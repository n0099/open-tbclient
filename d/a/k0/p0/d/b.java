package d.a.k0.p0.d;

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
import d.a.k0.p0.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends d.a.k0.x.b<d.a.k0.p0.c.a> {
    public WrapLineLayout m;
    public List<a> n;
    public int o;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f58096a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58097b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f58098c;

        /* renamed from: d.a.k0.p0.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnLongClickListenerC1463a implements View.OnLongClickListener {
            public View$OnLongClickListenerC1463a(b bVar) {
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

        /* renamed from: d.a.k0.p0.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1464b implements View.OnClickListener {
            public View$OnClickListenerC1464b(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f58097b.getText() == null || StringUtils.isNull(a.this.f58097b.getText().toString())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, a.this.f58097b.getText().toString()));
            }
        }

        /* loaded from: classes4.dex */
        public class c implements View.OnClickListener {
            public c(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f58097b.getText() == null) {
                    return;
                }
                e.b(a.this.f58097b.getText().toString());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
            }
        }

        public a() {
            View inflate = LayoutInflater.from(b.this.k().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.f58096a = inflate;
            this.f58097b = (TextView) inflate.findViewById(R.id.content);
            this.f58098c = (ImageView) this.f58096a.findViewById(R.id.delete);
            c();
            this.f58097b.setOnLongClickListener(new View$OnLongClickListenerC1463a(b.this));
            this.f58097b.setOnClickListener(new View$OnClickListenerC1464b(b.this));
            this.f58098c.setOnClickListener(new c(b.this));
        }

        public View b() {
            return this.f58096a;
        }

        public void c() {
            SkinManager.setViewTextColor(this.f58097b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f58097b, R.drawable.search_history_item_bg);
            SkinManager.setImageResource(this.f58098c, R.drawable.del_search_btn);
        }

        public void d(boolean z) {
            if (z) {
                this.f58098c.setVisibility(0);
                SkinManager.setImageResource(this.f58098c, R.drawable.del_search_btn);
                return;
            }
            this.f58098c.setVisibility(4);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = new ArrayList();
        this.o = 3;
        this.m = (WrapLineLayout) l();
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.forum_search_history_info;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
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

    public final a t() {
        return new a();
    }

    public final void u(int i2) {
        int size = this.n.size();
        if (size == i2) {
            return;
        }
        int i3 = 0;
        if (size < i2) {
            int i4 = i2 - size;
            while (i3 < i4) {
                a t = t();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds2);
                marginLayoutParams.topMargin = g2;
                marginLayoutParams.leftMargin = g2;
                this.m.addView(t.b(), marginLayoutParams);
                this.n.add(t);
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
    @Override // d.a.k0.x.b
    /* renamed from: v */
    public void m(d.a.k0.p0.c.a aVar) {
        if (aVar == null || ListUtils.isEmpty(aVar.h())) {
            return;
        }
        u(aVar.h().size());
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar2 = this.n.get(i2);
            if (aVar2 != null) {
                aVar2.d(false);
                aVar2.f58097b.setText(aVar.h().get(i2));
            }
        }
        n(this.f63161f, TbadkCoreApplication.getInst().getSkinType());
    }
}
