package d.b.i0.u2.f;

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
    public SimpleDateFormat f61418e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f61419f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f61420g;

    /* renamed from: h  reason: collision with root package name */
    public e f61421h;
    public d i;

    /* renamed from: d.b.i0.u2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1603a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61422e;

        public View$OnClickListenerC1603a(MuteUser muteUser) {
            this.f61422e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61421h != null) {
                MuteUser muteUser = this.f61422e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f61421h.a(this.f61422e.user_id.longValue(), this.f61422e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61424e;

        public b(MuteUser muteUser) {
            this.f61424e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f61424e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f61424e.user_id.longValue(), this.f61424e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61426e;

        public c(MuteUser muteUser) {
            this.f61426e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f61426e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f61426e.user_id.longValue(), this.f61426e.user_name);
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
        public View f61428a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f61429b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61430c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61431d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61432e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1603a view$OnClickListenerC1603a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f61420g = baseActivity;
        this.f61421h = eVar;
        this.i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f61420g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f61428a = inflate;
            fVar.f61430c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f61431d = (TextView) fVar.f61428a.findViewById(R.id.item_mute_terminate_time);
            fVar.f61432e = (TextView) fVar.f61428a.findViewById(R.id.item_remove_button);
            fVar.f61429b = (HeadImageView) fVar.f61428a.findViewById(R.id.item_header_view);
            fVar.f61428a.setTag(fVar);
            fVar.f61432e.setTag(Integer.valueOf(i));
            fVar.f61429b.setTag(Integer.valueOf(i));
            fVar.f61430c.setTag(Integer.valueOf(i));
        } else {
            fVar = (f) obj;
        }
        fVar.f61432e.setOnClickListener(new View$OnClickListenerC1603a(muteUser));
        fVar.f61429b.setOnClickListener(new b(muteUser));
        fVar.f61430c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f61429b.setTag(str);
            fVar.f61429b.W(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f61430c.setText(str2);
        } else {
            fVar.f61430c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f61431d.setText(this.f61420g.getResources().getString(R.string.auto_terminate_mute_time, this.f61418e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f61432e.setTag(l);
        }
        this.f61420g.getLayoutMode().j(fVar.f61428a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f61419f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f61419f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<MuteUser> arrayList = this.f61419f;
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
        MuteUser muteUser = this.f61419f.get(i);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f61428a;
        }
        return null;
    }
}
