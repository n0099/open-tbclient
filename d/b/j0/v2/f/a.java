package d.b.j0.v2.f;

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
    public SimpleDateFormat f63577e = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f63578f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f63579g;

    /* renamed from: h  reason: collision with root package name */
    public e f63580h;
    public d i;

    /* renamed from: d.b.j0.v2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1686a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f63581e;

        public View$OnClickListenerC1686a(MuteUser muteUser) {
            this.f63581e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63580h != null) {
                MuteUser muteUser = this.f63581e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.f63580h.a(this.f63581e.user_id.longValue(), this.f63581e.user_name);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f63583e;

        public b(MuteUser muteUser) {
            this.f63583e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f63583e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f63583e.user_id.longValue(), this.f63583e.user_name);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f63585e;

        public c(MuteUser muteUser) {
            this.f63585e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null) {
                MuteUser muteUser = this.f63585e;
                if (muteUser.user_id == null || muteUser.user_name == null) {
                    return;
                }
                a.this.i.a(this.f63585e.user_id.longValue(), this.f63585e.user_name);
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
        public View f63587a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f63588b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63589c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63590d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63591e;

        public f(a aVar) {
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1686a view$OnClickListenerC1686a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        this.f63579g = baseActivity;
        this.f63580h = eVar;
        this.i = dVar;
    }

    public final f c(Object obj, MuteUser muteUser, int i) {
        f fVar;
        if (obj == null) {
            fVar = new f(this, null);
            View inflate = LayoutInflater.from(this.f63579g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
            fVar.f63587a = inflate;
            fVar.f63589c = (TextView) inflate.findViewById(R.id.item_user_name);
            fVar.f63590d = (TextView) fVar.f63587a.findViewById(R.id.item_mute_terminate_time);
            fVar.f63591e = (TextView) fVar.f63587a.findViewById(R.id.item_remove_button);
            fVar.f63588b = (HeadImageView) fVar.f63587a.findViewById(R.id.item_header_view);
            fVar.f63587a.setTag(fVar);
            fVar.f63591e.setTag(Integer.valueOf(i));
            fVar.f63588b.setTag(Integer.valueOf(i));
            fVar.f63589c.setTag(Integer.valueOf(i));
        } else {
            fVar = (f) obj;
        }
        fVar.f63591e.setOnClickListener(new View$OnClickListenerC1686a(muteUser));
        fVar.f63588b.setOnClickListener(new b(muteUser));
        fVar.f63589c.setOnClickListener(new c(muteUser));
        String str = muteUser.portrait;
        if (str != null) {
            fVar.f63588b.setTag(str);
            fVar.f63588b.W(str, 12, false);
        }
        String str2 = muteUser.name_show;
        if (str2 != null) {
            fVar.f63589c.setText(str2);
        } else {
            fVar.f63589c.setText(muteUser.user_name);
        }
        if (muteUser.mute_time != null) {
            fVar.f63590d.setText(this.f63579g.getResources().getString(R.string.auto_terminate_mute_time, this.f63577e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
        }
        Long l = muteUser.user_id;
        if (l != null) {
            fVar.f63591e.setTag(l);
        }
        this.f63579g.getLayoutMode().j(fVar.f63587a);
        return fVar;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        this.f63578f = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MuteUser> arrayList = this.f63578f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<MuteUser> arrayList = this.f63578f;
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
        MuteUser muteUser = this.f63578f.get(i);
        if (muteUser != null) {
            fVar = c(view != null ? view.getTag() : null, muteUser, i);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar.f63587a;
        }
        return null;
    }
}
