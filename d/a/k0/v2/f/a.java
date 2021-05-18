package d.a.k0.v2.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f62547e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f62548f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f62549g;

    /* renamed from: h  reason: collision with root package name */
    public e f62550h;

    /* renamed from: i  reason: collision with root package name */
    public d f62551i;

    /* renamed from: d.a.k0.v2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1691a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f62552e;

        public View$OnClickListenerC1691a(MuteUser muteUser) {
            this.f62552e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f62550h != null) {
                MuteUser muteUser = this.f62552e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f62550h.a(this.f62552e.user_id.longValue(), this.f62552e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f62554e;

        public b(MuteUser muteUser) {
            this.f62554e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f62551i != null) {
                MuteUser muteUser = this.f62554e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f62551i.a(this.f62554e.user_id.longValue(), this.f62554e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f62556e;

        public c(MuteUser muteUser) {
            this.f62556e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f62551i != null) {
                MuteUser muteUser = this.f62556e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f62551i.a(this.f62556e.user_id.longValue(), this.f62556e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(long j, String str);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(long j, String str);
    }

    /* loaded from: classes5.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public View f62558a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f62559b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62560c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62561d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62562e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1691a view$OnClickListenerC1691a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f62549g = baseActivity;
        this.f62550h = eVar;
        this.f62551i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f62549g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f62558a = inflate;
            fVar.f62560c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f62561d = (TextView) fVar.f62558a.findViewById(R.id.item_mute_terminate_time);
            fVar.f62562e = (TextView) fVar.f62558a.findViewById(R.id.item_remove_button);
            fVar.f62559b = (HeadImageView) fVar.f62558a.findViewById(R.id.item_header_view);
            fVar.f62558a.setTag(fVar);
            fVar.f62562e.setTag(Integer.valueOf(i2));
            fVar.f62559b.setTag(Integer.valueOf(i2));
            fVar.f62560c.setTag(Integer.valueOf(i2));
        } else {
            fVar = (f) obj;
        }
        fVar.f62562e.setOnClickListener(new View$OnClickListenerC1691a(muteUser));
        fVar.f62559b.setOnClickListener(new b(muteUser));
        fVar.f62560c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f62559b.setTag(str);
            fVar.f62559b.V(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f62560c.setText(str2);
        } else {
            fVar.f62560c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f62561d.setText(this.f62549g.getResources().getString(R.string.auto_terminate_mute_time, this.f62547e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f62562e.setTag(l);
        }
        this.f62549g.getLayoutMode().j(fVar.f62558a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f62548f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f62548f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<MuteUser> arrayList = this.f62548f;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        f fVar;
        MuteUser muteUser = this.f62548f.get(i2);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i2);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f62558a;
        }
        return null;
    }
}
