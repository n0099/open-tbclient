package d.a.n0.p0.a;

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
import d.a.n0.p0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61652e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i> f61653f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public l f61654g;

    /* renamed from: h  reason: collision with root package name */
    public int f61655h;

    /* renamed from: i  reason: collision with root package name */
    public int f61656i;
    public d j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.j != null) {
                h.this.j.a(h.this.f61654g.b());
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
                h.this.j.a(h.this.f61654g.b());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public View f61659a;

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
        public RelativeLayout f61660a;

        /* renamed from: b  reason: collision with root package name */
        public BawuMemberInfoView f61661b;

        /* renamed from: c  reason: collision with root package name */
        public BawuMemberInfoView f61662c;

        /* renamed from: d  reason: collision with root package name */
        public BawuManagerApplyInfoView f61663d;

        /* renamed from: e  reason: collision with root package name */
        public BawuManagerApplyInfoView f61664e;

        public e(h hVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61665a;

        public f(h hVar) {
        }
    }

    public h(TbPageContext<?> tbPageContext) {
        this.f61655h = 0;
        this.f61656i = 0;
        this.f61652e = tbPageContext;
        this.f61655h = d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.f61656i = d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public i getItem(int i2) {
        ArrayList<i> arrayList = this.f61653f;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f61653f.get(i2);
    }

    public void d(ArrayList<i> arrayList) {
        this.f61653f = arrayList;
    }

    public void e(l lVar) {
        this.f61654g = lVar;
    }

    public void f(d dVar) {
        this.j = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> arrayList = this.f61653f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return getItem(i2).a();
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        e eVar;
        f fVar;
        if (getItemViewType(i2) == 0) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                view = LayoutInflater.from(this.f61652e.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                fVar = new f(this);
                fVar.f61665a = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(fVar);
            }
            fVar.f61665a.setText(((d.a.n0.p0.a.c) getItem(i2)).b());
            this.f61652e.getLayoutMode().j(view);
        } else if (getItemViewType(i2) == 1) {
            if (view != null && (view.getTag() instanceof e)) {
                eVar = (e) view.getTag();
                eVar.f61661b.setVisibility(0);
                eVar.f61662c.setVisibility(8);
                eVar.f61663d.setVisibility(8);
                eVar.f61664e.setVisibility(8);
            } else {
                view = LayoutInflater.from(this.f61652e.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                eVar = new e(this);
                eVar.f61660a = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                eVar.f61661b = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                eVar.f61662c = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                eVar.f61663d = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                eVar.f61664e = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(eVar);
            }
            d.a.n0.p0.a.b bVar = (d.a.n0.p0.a.b) getItem(i2);
            if (bVar != null && bVar.c() != null && bVar.c().size() > 0) {
                if (bVar.e() && bVar.b()) {
                    RelativeLayout relativeLayout = eVar.f61660a;
                    int i3 = this.f61655h;
                    relativeLayout.setPadding(i3, 0, i3, this.f61656i);
                    l lVar = this.f61654g;
                    if (lVar != null && !lVar.e()) {
                        if (bVar.c().size() == 2) {
                            if (bVar.d().equals(this.f61652e.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                eVar.f61664e.setVisibility(8);
                                eVar.f61663d.setVisibility(8);
                            } else if (bVar.d().equals(this.f61652e.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                eVar.f61664e.setVisibility(8);
                                eVar.f61663d.setVisibility(0);
                                eVar.f61663d.a(this.f61652e.getResources().getString(R.string.tip_assist_apply), this.f61654g.c());
                                eVar.f61663d.setOnClickListener(new a());
                            }
                        } else if (bVar.d().equals(this.f61652e.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            eVar.f61662c.setVisibility(8);
                            eVar.f61664e.setVisibility(8);
                            eVar.f61663d.setVisibility(8);
                        } else if (bVar.d().equals(this.f61652e.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            eVar.f61662c.setVisibility(8);
                            eVar.f61664e.setVisibility(0);
                            eVar.f61663d.setVisibility(8);
                            eVar.f61664e.a(this.f61652e.getResources().getString(R.string.tip_assist_apply), this.f61654g.c());
                            eVar.f61664e.setOnClickListener(new b());
                        }
                    }
                } else {
                    RelativeLayout relativeLayout2 = eVar.f61660a;
                    int i4 = this.f61655h;
                    relativeLayout2.setPadding(i4, 0, i4, 0);
                    eVar.f61663d.setVisibility(8);
                    eVar.f61664e.setVisibility(8);
                }
                eVar.f61661b.c(bVar.c().get(0));
                if (bVar.c().size() >= 2) {
                    eVar.f61662c.c(bVar.c().get(1));
                    eVar.f61662c.setVisibility(0);
                } else {
                    eVar.f61662c.setVisibility(8);
                }
                this.f61652e.getLayoutMode().j(view);
            }
        } else if (getItemViewType(i2) == 2) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f61652e.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                c cVar2 = new c(this);
                cVar2.f61659a = view.findViewById(R.id.divider_view);
                view.setTag(cVar2);
            }
            this.f61652e.getLayoutMode().j(view);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
