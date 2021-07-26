package d.a.q0.j1.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final TbPageContextSupport f59515e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.p0.t.f.a> f59516f;

    /* renamed from: g  reason: collision with root package name */
    public TbCheckBox.b f59517g;

    /* renamed from: h  reason: collision with root package name */
    public b f59518h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f59519i;
    public boolean j;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f59520a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f59521b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59522c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f59523d;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void c(View view, d.a.p0.t.f.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59518h = null;
        this.f59519i = null;
        this.f59515e = tbPageContextSupport;
        this.j = z;
    }

    public final a a(Object obj, d.a.p0.t.f.a aVar) {
        InterceptResult invokeLL;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, aVar)) == null) {
            if (obj == null) {
                aVar2 = b();
            } else {
                aVar2 = (a) obj;
            }
            b bVar = this.f59518h;
            if (bVar != null) {
                bVar.c(aVar2.f59520a, aVar);
            }
            c(aVar, aVar2, aVar.h());
            aVar2.f59522c.setText(aVar.g());
            if (this.j) {
                aVar2.f59523d.setVisibility(8);
            } else {
                aVar2.f59523d.setTagData(aVar);
            }
            TbPageContextSupport tbPageContextSupport = this.f59515e;
            if (tbPageContextSupport instanceof InviteFriendListActivity) {
                ((InviteFriendListActivity) tbPageContextSupport).getLayoutMode().j(aVar2.f59520a);
            }
            return aVar2;
        }
        return (a) invokeLL.objValue;
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = new a(this);
            View inflate = LayoutInflater.from(this.f59515e.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
            aVar.f59520a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
            aVar.f59521b = headImageView;
            headImageView.setIsRound(false);
            aVar.f59522c = (TextView) aVar.f59520a.findViewById(R.id.txt_user_name);
            TbCheckBox tbCheckBox = (TbCheckBox) aVar.f59520a.findViewById(R.id.ckb_select);
            aVar.f59523d = tbCheckBox;
            TbCheckBox.b bVar = this.f59517g;
            if (bVar != null) {
                tbCheckBox.setStatedChangedListener(bVar);
            }
            aVar.f59520a.setTag(aVar);
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void c(d.a.p0.t.f.a aVar, a aVar2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, aVar2, str) == null) || aVar == null) {
            return;
        }
        aVar2.f59521b.setTag(str);
        aVar2.f59521b.M(str, 12, false);
    }

    public void d(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f59517g = bVar;
        }
    }

    public void e(List<d.a.p0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f59516f = list;
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f59518h = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<d.a.p0.t.f.a> list = this.f59516f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<d.a.p0.t.f.a> list = this.f59516f;
            if (list == null) {
                return null;
            }
            return list.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            if (this.f59519i == null) {
                this.f59519i = viewGroup;
            }
            d.a.p0.t.f.a aVar2 = (d.a.p0.t.f.a) getItem(i2);
            if (aVar2 != null) {
                aVar = a(view != null ? view.getTag() : null, aVar2);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                return aVar.f59520a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
