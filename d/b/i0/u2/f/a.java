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
    public SimpleDateFormat f61417e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f61418f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f61419g;

    /* renamed from: h  reason: collision with root package name */
    public e f61420h;
    public d i;

    /* renamed from: d.b.i0.u2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1602a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61421e;

        public View$OnClickListenerC1602a(MuteUser muteUser) {
            this.f61421e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61420h != null) {
                MuteUser muteUser = this.f61421e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f61420h.a(this.f61421e.user_id.longValue(), this.f61421e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61423e;

        public b(MuteUser muteUser) {
            this.f61423e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f61423e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f61423e.user_id.longValue(), this.f61423e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61425e;

        public c(MuteUser muteUser) {
            this.f61425e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f61425e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f61425e.user_id.longValue(), this.f61425e.user_name);
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
        public View f61427a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f61428b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61429c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61430d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61431e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1602a view$OnClickListenerC1602a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f61419g = baseActivity;
        this.f61420h = eVar;
        this.i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f61419g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f61427a = inflate;
            fVar.f61429c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f61430d = (TextView) fVar.f61427a.findViewById(R.id.item_mute_terminate_time);
            fVar.f61431e = (TextView) fVar.f61427a.findViewById(R.id.item_remove_button);
            fVar.f61428b = (HeadImageView) fVar.f61427a.findViewById(R.id.item_header_view);
            fVar.f61427a.setTag(fVar);
            fVar.f61431e.setTag(Integer.valueOf(i));
            fVar.f61428b.setTag(Integer.valueOf(i));
            fVar.f61429c.setTag(Integer.valueOf(i));
        } else {
            fVar = (f) obj;
        }
        fVar.f61431e.setOnClickListener(new View$OnClickListenerC1602a(muteUser));
        fVar.f61428b.setOnClickListener(new b(muteUser));
        fVar.f61429c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f61428b.setTag(str);
            fVar.f61428b.W(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f61429c.setText(str2);
        } else {
            fVar.f61429c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f61430d.setText(this.f61419g.getResources().getString(R.string.auto_terminate_mute_time, this.f61417e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f61431e.setTag(l);
        }
        this.f61419g.getLayoutMode().j(fVar.f61427a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f61418f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f61418f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<MuteUser> arrayList = this.f61418f;
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
        MuteUser muteUser = this.f61418f.get(i);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f61427a;
        }
        return null;
    }
}
