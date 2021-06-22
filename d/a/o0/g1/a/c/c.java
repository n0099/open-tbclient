package d.a.o0.g1.a.c;

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
    public final TbPageContextSupport f58768e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.s.f.a> f58769f;

    /* renamed from: g  reason: collision with root package name */
    public TbCheckBox.b f58770g;

    /* renamed from: h  reason: collision with root package name */
    public b f58771h = null;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f58772i = null;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f58773a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f58774b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58775c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f58776d;

        public a(c cVar) {
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void c(View view, d.a.n0.s.f.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.f58768e = tbPageContextSupport;
        this.j = z;
    }

    public final a a(Object obj, d.a.n0.s.f.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = b();
        } else {
            aVar2 = (a) obj;
        }
        b bVar = this.f58771h;
        if (bVar != null) {
            bVar.c(aVar2.f58773a, aVar);
        }
        c(aVar, aVar2, aVar.h());
        aVar2.f58775c.setText(aVar.g());
        if (this.j) {
            aVar2.f58776d.setVisibility(8);
        } else {
            aVar2.f58776d.setTagData(aVar);
        }
        TbPageContextSupport tbPageContextSupport = this.f58768e;
        if (tbPageContextSupport instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) tbPageContextSupport).getLayoutMode().j(aVar2.f58773a);
        }
        return aVar2;
    }

    public final a b() {
        a aVar = new a(this);
        View inflate = LayoutInflater.from(this.f58768e.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.f58773a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
        aVar.f58774b = headImageView;
        headImageView.setIsRound(false);
        aVar.f58775c = (TextView) aVar.f58773a.findViewById(R.id.txt_user_name);
        TbCheckBox tbCheckBox = (TbCheckBox) aVar.f58773a.findViewById(R.id.ckb_select);
        aVar.f58776d = tbCheckBox;
        TbCheckBox.b bVar = this.f58770g;
        if (bVar != null) {
            tbCheckBox.setStatedChangedListener(bVar);
        }
        aVar.f58773a.setTag(aVar);
        return aVar;
    }

    public final void c(d.a.n0.s.f.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.f58774b.setTag(str);
            aVar2.f58774b.U(str, 12, false);
        }
    }

    public void d(TbCheckBox.b bVar) {
        this.f58770g = bVar;
    }

    public void e(List<d.a.n0.s.f.a> list) {
        this.f58769f = list;
    }

    public void f(b bVar) {
        this.f58771h = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.n0.s.f.a> list = this.f58769f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<d.a.n0.s.f.a> list = this.f58769f;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.f58772i == null) {
            this.f58772i = viewGroup;
        }
        d.a.n0.s.f.a aVar2 = (d.a.n0.s.f.a) getItem(i2);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.f58773a;
        }
        return null;
    }
}
