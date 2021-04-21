package d.b.j0.o0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuManagerApplyInfoView;
import com.baidu.tieba.forumMember.bawu.BawuMemberInfoView;
import d.b.j0.o0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59121e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i> f59122f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public l f59123g;

    /* renamed from: h  reason: collision with root package name */
    public int f59124h;
    public int i;
    public d j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.j != null) {
                h.this.j.a(h.this.f59123g.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.j != null) {
                h.this.j.a(h.this.f59123g.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f59127a;

        public c(h hVar) {
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(String str);
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f59128a;

        /* renamed from: b  reason: collision with root package name */
        public BawuMemberInfoView f59129b;

        /* renamed from: c  reason: collision with root package name */
        public BawuMemberInfoView f59130c;

        /* renamed from: d  reason: collision with root package name */
        public BawuManagerApplyInfoView f59131d;

        /* renamed from: e  reason: collision with root package name */
        public BawuManagerApplyInfoView f59132e;

        public e(h hVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59133a;

        public f(h hVar) {
        }
    }

    public h(TbPageContext<?> tbPageContext) {
        this.f59124h = 0;
        this.i = 0;
        this.f59121e = tbPageContext;
        this.f59124h = d.b.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.i = d.b.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public i getItem(int i) {
        ArrayList<i> arrayList = this.f59122f;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.f59122f.get(i);
    }

    public void d(ArrayList<i> arrayList) {
        this.f59122f = arrayList;
    }

    public void e(l lVar) {
        this.f59123g = lVar;
    }

    public void f(d dVar) {
        this.j = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> arrayList = this.f59122f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).a();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        f fVar;
        if (getItemViewType(i) == 0) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                view = LayoutInflater.from(this.f59121e.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                fVar = new f(this);
                fVar.f59133a = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(fVar);
            }
            fVar.f59133a.setText(((d.b.j0.o0.a.c) getItem(i)).b());
            this.f59121e.getLayoutMode().j(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof e)) {
                eVar = (e) view.getTag();
                eVar.f59129b.setVisibility(0);
                eVar.f59130c.setVisibility(8);
                eVar.f59131d.setVisibility(8);
                eVar.f59132e.setVisibility(8);
            } else {
                view = LayoutInflater.from(this.f59121e.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                eVar = new e(this);
                eVar.f59128a = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                eVar.f59129b = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                eVar.f59130c = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                eVar.f59131d = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                eVar.f59132e = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(eVar);
            }
            d.b.j0.o0.a.b bVar = (d.b.j0.o0.a.b) getItem(i);
            if (bVar != null && bVar.c() != null && bVar.c().size() > 0) {
                if (bVar.e() && bVar.b()) {
                    RelativeLayout relativeLayout = eVar.f59128a;
                    int i2 = this.f59124h;
                    relativeLayout.setPadding(i2, 0, i2, this.i);
                    l lVar = this.f59123g;
                    if (lVar != null && !lVar.f()) {
                        if (bVar.c().size() == 2) {
                            if (bVar.d().equals(this.f59121e.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                eVar.f59132e.setVisibility(8);
                                eVar.f59131d.setVisibility(8);
                            } else if (bVar.d().equals(this.f59121e.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                eVar.f59132e.setVisibility(8);
                                eVar.f59131d.setVisibility(0);
                                eVar.f59131d.a(this.f59121e.getResources().getString(R.string.tip_assist_apply), this.f59123g.e());
                                eVar.f59131d.setOnClickListener(new a());
                            }
                        } else if (bVar.d().equals(this.f59121e.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            eVar.f59130c.setVisibility(8);
                            eVar.f59132e.setVisibility(8);
                            eVar.f59131d.setVisibility(8);
                        } else if (bVar.d().equals(this.f59121e.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            eVar.f59130c.setVisibility(8);
                            eVar.f59132e.setVisibility(0);
                            eVar.f59131d.setVisibility(8);
                            eVar.f59132e.a(this.f59121e.getResources().getString(R.string.tip_assist_apply), this.f59123g.e());
                            eVar.f59132e.setOnClickListener(new b());
                        }
                    }
                } else {
                    RelativeLayout relativeLayout2 = eVar.f59128a;
                    int i3 = this.f59124h;
                    relativeLayout2.setPadding(i3, 0, i3, 0);
                    eVar.f59131d.setVisibility(8);
                    eVar.f59132e.setVisibility(8);
                }
                eVar.f59129b.c(bVar.c().get(0));
                if (bVar.c().size() >= 2) {
                    eVar.f59130c.c(bVar.c().get(1));
                    eVar.f59130c.setVisibility(0);
                } else {
                    eVar.f59130c.setVisibility(8);
                }
                this.f59121e.getLayoutMode().j(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f59121e.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                c cVar2 = new c(this);
                cVar2.f59127a = view.findViewById(R.id.divider_view);
                view.setTag(cVar2);
            }
            this.f59121e.getLayoutMode().j(view);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
