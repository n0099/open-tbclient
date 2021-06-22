package d.a.o0.w2.f;

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
    public SimpleDateFormat f66494e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f66495f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f66496g;

    /* renamed from: h  reason: collision with root package name */
    public e f66497h;

    /* renamed from: i  reason: collision with root package name */
    public d f66498i;

    /* renamed from: d.a.o0.w2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1765a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f66499e;

        public View$OnClickListenerC1765a(MuteUser muteUser) {
            this.f66499e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f66497h != null) {
                MuteUser muteUser = this.f66499e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f66497h.a(this.f66499e.user_id.longValue(), this.f66499e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f66501e;

        public b(MuteUser muteUser) {
            this.f66501e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f66498i != null) {
                MuteUser muteUser = this.f66501e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f66498i.a(this.f66501e.user_id.longValue(), this.f66501e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f66503e;

        public c(MuteUser muteUser) {
            this.f66503e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f66498i != null) {
                MuteUser muteUser = this.f66503e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f66498i.a(this.f66503e.user_id.longValue(), this.f66503e.user_name);
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
        public View f66505a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f66506b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f66507c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66508d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66509e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1765a view$OnClickListenerC1765a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f66496g = baseActivity;
        this.f66497h = eVar;
        this.f66498i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f66496g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f66505a = inflate;
            fVar.f66507c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f66508d = (TextView) fVar.f66505a.findViewById(R.id.item_mute_terminate_time);
            fVar.f66509e = (TextView) fVar.f66505a.findViewById(R.id.item_remove_button);
            fVar.f66506b = (HeadImageView) fVar.f66505a.findViewById(R.id.item_header_view);
            fVar.f66505a.setTag(fVar);
            fVar.f66509e.setTag(Integer.valueOf(i2));
            fVar.f66506b.setTag(Integer.valueOf(i2));
            fVar.f66507c.setTag(Integer.valueOf(i2));
        } else {
            fVar = (f) obj;
        }
        fVar.f66509e.setOnClickListener(new View$OnClickListenerC1765a(muteUser));
        fVar.f66506b.setOnClickListener(new b(muteUser));
        fVar.f66507c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f66506b.setTag(str);
            fVar.f66506b.U(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f66507c.setText(str2);
        } else {
            fVar.f66507c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f66508d.setText(this.f66496g.getResources().getString(R.string.auto_terminate_mute_time, this.f66494e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f66509e.setTag(l);
        }
        this.f66496g.getLayoutMode().j(fVar.f66505a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f66495f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f66495f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<MuteUser> arrayList = this.f66495f;
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
        MuteUser muteUser = this.f66495f.get(i2);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i2);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f66505a;
        }
        return null;
    }
}
