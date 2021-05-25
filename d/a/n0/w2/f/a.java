package d.a.n0.w2.f;

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
    public SimpleDateFormat f62654e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f62655f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f62656g;

    /* renamed from: h  reason: collision with root package name */
    public e f62657h;

    /* renamed from: i  reason: collision with root package name */
    public d f62658i;

    /* renamed from: d.a.n0.w2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1704a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f62659e;

        public View$OnClickListenerC1704a(MuteUser muteUser) {
            this.f62659e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f62657h != null) {
                MuteUser muteUser = this.f62659e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f62657h.a(this.f62659e.user_id.longValue(), this.f62659e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f62661e;

        public b(MuteUser muteUser) {
            this.f62661e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f62658i != null) {
                MuteUser muteUser = this.f62661e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f62658i.a(this.f62661e.user_id.longValue(), this.f62661e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f62663e;

        public c(MuteUser muteUser) {
            this.f62663e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f62658i != null) {
                MuteUser muteUser = this.f62663e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f62658i.a(this.f62663e.user_id.longValue(), this.f62663e.user_name);
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
        public View f62665a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f62666b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62667c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62668d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62669e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1704a view$OnClickListenerC1704a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f62656g = baseActivity;
        this.f62657h = eVar;
        this.f62658i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f62656g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f62665a = inflate;
            fVar.f62667c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f62668d = (TextView) fVar.f62665a.findViewById(R.id.item_mute_terminate_time);
            fVar.f62669e = (TextView) fVar.f62665a.findViewById(R.id.item_remove_button);
            fVar.f62666b = (HeadImageView) fVar.f62665a.findViewById(R.id.item_header_view);
            fVar.f62665a.setTag(fVar);
            fVar.f62669e.setTag(Integer.valueOf(i2));
            fVar.f62666b.setTag(Integer.valueOf(i2));
            fVar.f62667c.setTag(Integer.valueOf(i2));
        } else {
            fVar = (f) obj;
        }
        fVar.f62669e.setOnClickListener(new View$OnClickListenerC1704a(muteUser));
        fVar.f62666b.setOnClickListener(new b(muteUser));
        fVar.f62667c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f62666b.setTag(str);
            fVar.f62666b.V(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f62667c.setText(str2);
        } else {
            fVar.f62667c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f62668d.setText(this.f62656g.getResources().getString(R.string.auto_terminate_mute_time, this.f62654e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f62669e.setTag(l);
        }
        this.f62656g.getLayoutMode().j(fVar.f62665a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f62655f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f62655f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<MuteUser> arrayList = this.f62655f;
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
        MuteUser muteUser = this.f62655f.get(i2);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i2);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f62665a;
        }
        return null;
    }
}
