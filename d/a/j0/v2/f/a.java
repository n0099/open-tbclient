package d.a.j0.v2.f;

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
    public SimpleDateFormat f61823e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f61824f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f61825g;

    /* renamed from: h  reason: collision with root package name */
    public e f61826h;

    /* renamed from: i  reason: collision with root package name */
    public d f61827i;

    /* renamed from: d.a.j0.v2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1626a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61828e;

        public View$OnClickListenerC1626a(MuteUser muteUser) {
            this.f61828e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61826h != null) {
                MuteUser muteUser = this.f61828e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f61826h.a(this.f61828e.user_id.longValue(), this.f61828e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61830e;

        public b(MuteUser muteUser) {
            this.f61830e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61827i != null) {
                MuteUser muteUser = this.f61830e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f61827i.a(this.f61830e.user_id.longValue(), this.f61830e.user_name);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f61832e;

        public c(MuteUser muteUser) {
            this.f61832e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61827i != null) {
                MuteUser muteUser = this.f61832e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f61827i.a(this.f61832e.user_id.longValue(), this.f61832e.user_name);
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
        public View f61834a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f61835b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61836c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61837d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61838e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1626a view$OnClickListenerC1626a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f61825g = baseActivity;
        this.f61826h = eVar;
        this.f61827i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f61825g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f61834a = inflate;
            fVar.f61836c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f61837d = (TextView) fVar.f61834a.findViewById(R.id.item_mute_terminate_time);
            fVar.f61838e = (TextView) fVar.f61834a.findViewById(R.id.item_remove_button);
            fVar.f61835b = (HeadImageView) fVar.f61834a.findViewById(R.id.item_header_view);
            fVar.f61834a.setTag(fVar);
            fVar.f61838e.setTag(Integer.valueOf(i2));
            fVar.f61835b.setTag(Integer.valueOf(i2));
            fVar.f61836c.setTag(Integer.valueOf(i2));
        } else {
            fVar = (f) obj;
        }
        fVar.f61838e.setOnClickListener(new View$OnClickListenerC1626a(muteUser));
        fVar.f61835b.setOnClickListener(new b(muteUser));
        fVar.f61836c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f61835b.setTag(str);
            fVar.f61835b.V(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f61836c.setText(str2);
        } else {
            fVar.f61836c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f61837d.setText(this.f61825g.getResources().getString(R.string.auto_terminate_mute_time, this.f61823e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f61838e.setTag(l);
        }
        this.f61825g.getLayoutMode().j(fVar.f61834a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f61824f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f61824f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<MuteUser> arrayList = this.f61824f;
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
        MuteUser muteUser = this.f61824f.get(i2);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i2);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f61834a;
        }
        return null;
    }
}
