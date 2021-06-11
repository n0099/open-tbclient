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
    public SimpleDateFormat f66369e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f66370f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f66371g;

    /* renamed from: h  reason: collision with root package name */
    public e f66372h;

    /* renamed from: i  reason: collision with root package name */
    public d f66373i;

    /* renamed from: d.a.n0.w2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1761a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f66374e;

        public View$OnClickListenerC1761a(MuteUser muteUser) {
            this.f66374e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f66372h != null) {
                MuteUser muteUser = this.f66374e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f66372h.a(this.f66374e.user_id.longValue(), this.f66374e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f66376e;

        public b(MuteUser muteUser) {
            this.f66376e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f66373i != null) {
                MuteUser muteUser = this.f66376e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f66373i.a(this.f66376e.user_id.longValue(), this.f66376e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f66378e;

        public c(MuteUser muteUser) {
            this.f66378e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f66373i != null) {
                MuteUser muteUser = this.f66378e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f66373i.a(this.f66378e.user_id.longValue(), this.f66378e.user_name);
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
        public View f66380a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f66381b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f66382c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66383d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66384e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1761a view$OnClickListenerC1761a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f66371g = baseActivity;
        this.f66372h = eVar;
        this.f66373i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f66371g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f66380a = inflate;
            fVar.f66382c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f66383d = (TextView) fVar.f66380a.findViewById(R.id.item_mute_terminate_time);
            fVar.f66384e = (TextView) fVar.f66380a.findViewById(R.id.item_remove_button);
            fVar.f66381b = (HeadImageView) fVar.f66380a.findViewById(R.id.item_header_view);
            fVar.f66380a.setTag(fVar);
            fVar.f66384e.setTag(Integer.valueOf(i2));
            fVar.f66381b.setTag(Integer.valueOf(i2));
            fVar.f66382c.setTag(Integer.valueOf(i2));
        } else {
            fVar = (f) obj;
        }
        fVar.f66384e.setOnClickListener(new View$OnClickListenerC1761a(muteUser));
        fVar.f66381b.setOnClickListener(new b(muteUser));
        fVar.f66382c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f66381b.setTag(str);
            fVar.f66381b.U(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f66382c.setText(str2);
        } else {
            fVar.f66382c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f66383d.setText(this.f66371g.getResources().getString(R.string.auto_terminate_mute_time, this.f66369e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f66384e.setTag(l);
        }
        this.f66371g.getLayoutMode().j(fVar.f66380a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f66370f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f66370f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<MuteUser> arrayList = this.f66370f;
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
        MuteUser muteUser = this.f66370f.get(i2);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i2);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f66380a;
        }
        return null;
    }
}
