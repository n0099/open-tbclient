package com.repackage;

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
/* loaded from: classes7.dex */
public class z97 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContextSupport a;
    public List<wy4> b;
    public TbCheckBox.b c;
    public b d;
    public ViewGroup e;
    public boolean f;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public HeadImageView b;
        public TextView c;
        public TbCheckBox d;

        public a(z97 z97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void b(View view2, wy4 wy4Var);
    }

    public z97(TbPageContextSupport tbPageContextSupport, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.a = tbPageContextSupport;
        this.f = z;
    }

    public final a a(Object obj, wy4 wy4Var) {
        InterceptResult invokeLL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, wy4Var)) == null) {
            if (obj == null) {
                aVar = b();
            } else {
                aVar = (a) obj;
            }
            b bVar = this.d;
            if (bVar != null) {
                bVar.b(aVar.a, wy4Var);
            }
            c(wy4Var, aVar, wy4Var.h());
            aVar.c.setText(wy4Var.g());
            if (this.f) {
                aVar.d.setVisibility(8);
            } else {
                aVar.d.setTagData(wy4Var);
            }
            TbPageContextSupport tbPageContextSupport = this.a;
            if (tbPageContextSupport instanceof InviteFriendListActivity) {
                ((InviteFriendListActivity) tbPageContextSupport).getLayoutMode().j(aVar.a);
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = new a(this);
            View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d03e8, (ViewGroup) null);
            aVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09187a);
            aVar.b = headImageView;
            headImageView.setIsRound(false);
            aVar.c = (TextView) aVar.a.findViewById(R.id.obfuscated_res_0x7f092283);
            TbCheckBox tbCheckBox = (TbCheckBox) aVar.a.findViewById(R.id.obfuscated_res_0x7f09064f);
            aVar.d = tbCheckBox;
            TbCheckBox.b bVar = this.c;
            if (bVar != null) {
                tbCheckBox.setStatedChangedListener(bVar);
            }
            aVar.a.setTag(aVar);
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void c(wy4 wy4Var, a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, wy4Var, aVar, str) == null) || wy4Var == null) {
            return;
        }
        aVar.b.setTag(str);
        aVar.b.K(str, 12, false);
    }

    public void d(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void e(List<wy4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.b = list;
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.d = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<wy4> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<wy4> list = this.b;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (this.e == null) {
                this.e = viewGroup;
            }
            wy4 wy4Var = (wy4) getItem(i);
            if (wy4Var != null) {
                aVar = a(view2 != null ? view2.getTag() : null, wy4Var);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                return aVar.a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
