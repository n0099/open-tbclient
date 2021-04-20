package d.b.i0.v2.f;

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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f63156e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f63157f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f63158g;

    /* renamed from: h  reason: collision with root package name */
    public e f63159h;
    public d i;

    /* renamed from: d.b.i0.v2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1663a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f63160e;

        public View$OnClickListenerC1663a(MuteUser muteUser) {
            this.f63160e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63159h != null) {
                MuteUser muteUser = this.f63160e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f63159h.a(this.f63160e.user_id.longValue(), this.f63160e.user_name);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f63162e;

        public b(MuteUser muteUser) {
            this.f63162e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f63162e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f63162e.user_id.longValue(), this.f63162e.user_name);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f63164e;

        public c(MuteUser muteUser) {
            this.f63164e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f63164e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f63164e.user_id.longValue(), this.f63164e.user_name);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(long j, String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(long j, String str);
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public View f63166a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f63167b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63168c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63169d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63170e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1663a view$OnClickListenerC1663a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f63158g = baseActivity;
        this.f63159h = eVar;
        this.i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f63158g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f63166a = inflate;
            fVar.f63168c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f63169d = (TextView) fVar.f63166a.findViewById(R.id.item_mute_terminate_time);
            fVar.f63170e = (TextView) fVar.f63166a.findViewById(R.id.item_remove_button);
            fVar.f63167b = (HeadImageView) fVar.f63166a.findViewById(R.id.item_header_view);
            fVar.f63166a.setTag(fVar);
            fVar.f63170e.setTag(Integer.valueOf(i));
            fVar.f63167b.setTag(Integer.valueOf(i));
            fVar.f63168c.setTag(Integer.valueOf(i));
        } else {
            fVar = (f) obj;
        }
        fVar.f63170e.setOnClickListener(new View$OnClickListenerC1663a(muteUser));
        fVar.f63167b.setOnClickListener(new b(muteUser));
        fVar.f63168c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f63167b.setTag(str);
            fVar.f63167b.W(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f63168c.setText(str2);
        } else {
            fVar.f63168c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f63169d.setText(this.f63158g.getResources().getString(R.string.auto_terminate_mute_time, this.f63156e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f63170e.setTag(l);
        }
        this.f63158g.getLayoutMode().j(fVar.f63166a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f63157f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f63157f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<MuteUser> arrayList = this.f63157f;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        MuteUser muteUser = this.f63157f.get(i);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f63166a;
        }
        return null;
    }
}
