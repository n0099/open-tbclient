package d.b.j0.f1.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final TbPageContextSupport f56182e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.s.f.a> f56183f;

    /* renamed from: g  reason: collision with root package name */
    public TbCheckBox.b f56184g;

    /* renamed from: h  reason: collision with root package name */
    public b f56185h = null;
    public ViewGroup i = null;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f56186a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f56187b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56188c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f56189d;

        public a(c cVar) {
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void c(View view, d.b.i0.s.f.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.f56182e = tbPageContextSupport;
        this.j = z;
    }

    public final a a(Object obj, d.b.i0.s.f.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = b();
        } else {
            aVar2 = (a) obj;
        }
        b bVar = this.f56185h;
        if (bVar != null) {
            bVar.c(aVar2.f56186a, aVar);
        }
        c(aVar, aVar2, aVar.h());
        aVar2.f56188c.setText(aVar.g());
        if (this.j) {
            aVar2.f56189d.setVisibility(8);
        } else {
            aVar2.f56189d.setTagData(aVar);
        }
        TbPageContextSupport tbPageContextSupport = this.f56182e;
        if (tbPageContextSupport instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) tbPageContextSupport).getLayoutMode().j(aVar2.f56186a);
        }
        return aVar2;
    }

    public final a b() {
        a aVar = new a(this);
        View inflate = LayoutInflater.from(this.f56182e.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.f56186a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
        aVar.f56187b = headImageView;
        headImageView.setIsRound(false);
        aVar.f56188c = (TextView) aVar.f56186a.findViewById(R.id.txt_user_name);
        TbCheckBox tbCheckBox = (TbCheckBox) aVar.f56186a.findViewById(R.id.ckb_select);
        aVar.f56189d = tbCheckBox;
        TbCheckBox.b bVar = this.f56184g;
        if (bVar != null) {
            tbCheckBox.setStatedChangedListener(bVar);
        }
        aVar.f56186a.setTag(aVar);
        return aVar;
    }

    public final void c(d.b.i0.s.f.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.f56187b.setTag(str);
            aVar2.f56187b.W(str, 12, false);
        }
    }

    public void d(TbCheckBox.b bVar) {
        this.f56184g = bVar;
    }

    public void e(List<d.b.i0.s.f.a> list) {
        this.f56183f = list;
    }

    public void f(b bVar) {
        this.f56185h = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.s.f.a> list = this.f56183f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<d.b.i0.s.f.a> list = this.f56183f;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.i == null) {
            this.i = viewGroup;
        }
        d.b.i0.s.f.a aVar2 = (d.b.i0.s.f.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.f56186a;
        }
        return null;
    }
}
