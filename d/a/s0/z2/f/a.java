package d.a.s0.z2.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDateFormat f69890e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MuteUser> f69891f;

    /* renamed from: g  reason: collision with root package name */
    public BaseActivity f69892g;

    /* renamed from: h  reason: collision with root package name */
    public e f69893h;

    /* renamed from: i  reason: collision with root package name */
    public d f69894i;

    /* renamed from: d.a.s0.z2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1908a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f69895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f69896f;

        public View$OnClickListenerC1908a(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69896f = aVar;
            this.f69895e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f69896f.f69893h == null) {
                return;
            }
            MuteUser muteUser = this.f69895e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f69896f.f69893h.a(this.f69895e.user_id.longValue(), this.f69895e.user_name);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f69897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f69898f;

        public b(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69898f = aVar;
            this.f69897e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f69898f.f69894i == null) {
                return;
            }
            MuteUser muteUser = this.f69897e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f69898f.f69894i.a(this.f69897e.user_id.longValue(), this.f69897e.user_name);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MuteUser f69899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f69900f;

        public c(a aVar, MuteUser muteUser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, muteUser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69900f = aVar;
            this.f69899e = muteUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f69900f.f69894i == null) {
                return;
            }
            MuteUser muteUser = this.f69899e;
            if (muteUser.user_id == null || muteUser.user_name == null) {
                return;
            }
            this.f69900f.f69894i.a(this.f69899e.user_id.longValue(), this.f69899e.user_name);
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(long j, String str);
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(long j, String str);
    }

    /* loaded from: classes9.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f69901a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f69902b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f69903c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f69904d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f69905e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(a aVar, View$OnClickListenerC1908a view$OnClickListenerC1908a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, eVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69892g = baseActivity;
        this.f69893h = eVar;
        this.f69894i = dVar;
        this.f69890e = new SimpleDateFormat("yyyy.MM.dd");
    }

    public final f c(Object obj, MuteUser muteUser, int i2) {
        InterceptResult invokeLLI;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, obj, muteUser, i2)) == null) {
            if (obj == null) {
                fVar = new f(this, null);
                View inflate = LayoutInflater.from(this.f69892g.getPageContext().getContext()).inflate(R.layout.user_mute_list_item, (ViewGroup) null);
                fVar.f69901a = inflate;
                fVar.f69903c = (TextView) inflate.findViewById(R.id.item_user_name);
                fVar.f69904d = (TextView) fVar.f69901a.findViewById(R.id.item_mute_terminate_time);
                fVar.f69905e = (TextView) fVar.f69901a.findViewById(R.id.item_remove_button);
                fVar.f69902b = (HeadImageView) fVar.f69901a.findViewById(R.id.item_header_view);
                fVar.f69901a.setTag(fVar);
                fVar.f69905e.setTag(Integer.valueOf(i2));
                fVar.f69902b.setTag(Integer.valueOf(i2));
                fVar.f69903c.setTag(Integer.valueOf(i2));
            } else {
                fVar = (f) obj;
            }
            fVar.f69905e.setOnClickListener(new View$OnClickListenerC1908a(this, muteUser));
            fVar.f69902b.setOnClickListener(new b(this, muteUser));
            fVar.f69903c.setOnClickListener(new c(this, muteUser));
            String str = muteUser.portrait;
            if (str != null) {
                fVar.f69902b.setTag(str);
                fVar.f69902b.M(str, 12, false);
            }
            String str2 = muteUser.name_show;
            if (str2 != null) {
                fVar.f69903c.setText(str2);
            } else {
                fVar.f69903c.setText(muteUser.user_name);
            }
            if (muteUser.mute_time != null) {
                fVar.f69904d.setText(this.f69892g.getResources().getString(R.string.auto_terminate_mute_time, this.f69890e.format((Date) new java.sql.Date(muteUser.mute_time.intValue() * 1000))));
            }
            Long l = muteUser.user_id;
            if (l != null) {
                fVar.f69905e.setTag(l);
            }
            this.f69892g.getLayoutMode().j(fVar.f69901a);
            return fVar;
        }
        return (f) invokeLLI.objValue;
    }

    public void d(ArrayList<MuteUser> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f69891f = arrayList;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<MuteUser> arrayList = this.f69891f;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ArrayList<MuteUser> arrayList = this.f69891f;
            if (arrayList != null) {
                return arrayList.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            MuteUser muteUser = this.f69891f.get(i2);
            if (muteUser != null) {
                fVar = c(view != null ? view.getTag() : null, muteUser, i2);
            } else {
                fVar = null;
            }
            if (fVar != null) {
                return fVar.f69901a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
