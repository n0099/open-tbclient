package d.b.i0.p0.d;

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
import d.b.c.e.p.l;
import d.b.i0.p0.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.b<d.b.i0.p0.c.a> {
    public WrapLineLayout m;
    public List<a> n;
    public int o;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f58897a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58898b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f58899c;

        /* renamed from: d.b.i0.p0.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnLongClickListenerC1427a implements View.OnLongClickListener {
            public View$OnLongClickListenerC1427a(b bVar) {
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

        /* renamed from: d.b.i0.p0.d.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1428b implements View.OnClickListener {
            public View$OnClickListenerC1428b(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f58898b.getText() == null || StringUtils.isNull(a.this.f58898b.getText().toString())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, a.this.f58898b.getText().toString()));
            }
        }

        /* loaded from: classes4.dex */
        public class c implements View.OnClickListener {
            public c(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f58898b.getText() == null) {
                    return;
                }
                e.b(a.this.f58898b.getText().toString());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
            }
        }

        public a() {
            View inflate = LayoutInflater.from(b.this.l().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.f58897a = inflate;
            this.f58898b = (TextView) inflate.findViewById(R.id.content);
            this.f58899c = (ImageView) this.f58897a.findViewById(R.id.delete);
            c();
            this.f58898b.setOnLongClickListener(new View$OnLongClickListenerC1427a(b.this));
            this.f58898b.setOnClickListener(new View$OnClickListenerC1428b(b.this));
            this.f58899c.setOnClickListener(new c(b.this));
        }

        public View b() {
            return this.f58897a;
        }

        public void c() {
            SkinManager.setViewTextColor(this.f58898b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f58898b, R.drawable.search_history_item_bg);
            SkinManager.setImageResource(this.f58899c, R.drawable.del_search_btn);
        }

        public void d(boolean z) {
            if (z) {
                this.f58899c.setVisibility(0);
                SkinManager.setImageResource(this.f58899c, R.drawable.del_search_btn);
                return;
            }
            this.f58899c.setVisibility(4);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = new ArrayList();
        this.o = 3;
        this.m = (WrapLineLayout) m();
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.forum_search_history_info;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.o == i) {
            return;
        }
        for (a aVar : this.n) {
            if (aVar != null) {
                aVar.c();
            }
        }
        this.o = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final a v() {
        return new a();
    }

    public final void w(int i) {
        int size = this.n.size();
        if (size == i) {
            return;
        }
        int i2 = 0;
        if (size < i) {
            int i3 = i - size;
            while (i2 < i3) {
                a v = v();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds2);
                marginLayoutParams.topMargin = g2;
                marginLayoutParams.leftMargin = g2;
                this.m.addView(v.b(), marginLayoutParams);
                this.n.add(v);
                i2++;
            }
        } else if (i == 0) {
            this.m.removeAllViews();
            this.n.clear();
        } else if (size > i) {
            int i4 = size - i;
            while (i2 < i4) {
                this.m.removeView(this.n.get(i2).b());
                this.n.remove(i2);
                i2++;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: x */
    public void n(d.b.i0.p0.c.a aVar) {
        if (aVar == null || ListUtils.isEmpty(aVar.g())) {
            return;
        }
        w(aVar.g().size());
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            a aVar2 = this.n.get(i);
            if (aVar2 != null) {
                aVar2.d(false);
                aVar2.f58898b.setText(aVar.g().get(i));
            }
        }
        o(this.f63756f, TbadkCoreApplication.getInst().getSkinType());
    }
}
