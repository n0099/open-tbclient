package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonFriendActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class y28 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<UserData> a;
    public PersonFriendActivity b;
    public boolean c;
    public ArrayList<ProgressBar> d;
    public boolean e;
    public boolean f;
    public int g;
    public View.OnClickListener h;
    public View.OnClickListener i;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public LinearLayout e;
        public ProgressBar f;
        public TextView g;
        public ImageView h;

        public b(y28 y28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(y28 y28Var, a aVar) {
            this(y28Var);
        }
    }

    public y28(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personFriendActivity, Boolean.valueOf(z), Integer.valueOf(i), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.e = false;
        this.f = true;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.b = personFriendActivity;
        this.d = new ArrayList<>();
        this.f = z;
        this.g = i;
        this.h = onClickListener;
        this.i = onClickListener2;
    }

    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.b.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.b.getLayoutMode().j(view2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = false;
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            this.e = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.d == null) {
            return;
        }
        for (int i = 0; i < this.d.size(); i++) {
            try {
                this.d.get(i).setVisibility(8);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        this.d.clear();
    }

    public void d(ArrayList<UserData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c = z;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.a;
            int size = arrayList != null ? arrayList.size() : 0;
            return this.c ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.e) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.a;
            return (arrayList == null || i >= arrayList.size()) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (this.a == null) {
                return view2;
            }
            if (view2 == null) {
                bVar = new b(this, null);
                if (getItemViewType(i) == 0) {
                    view3 = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06c8, (ViewGroup) null);
                    HeadImageView headImageView = (HeadImageView) view3.findViewById(R.id.obfuscated_res_0x7f091823);
                    bVar.a = headImageView;
                    headImageView.setIsRound(false);
                    bVar.a.setAutoChangeStyle(true);
                    bVar.e = (LinearLayout) view3.findViewById(R.id.obfuscated_res_0x7f090eef);
                    bVar.b = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f0914e4);
                    bVar.g = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f0902bc);
                    bVar.c = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090f41);
                    bVar.d = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0905fd);
                    bVar.h = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907df);
                    bVar.d.setOnClickListener(this.h);
                } else {
                    view3 = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0600, (ViewGroup) null);
                    bVar.b = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f0916ea);
                    view3.setOnClickListener(this.i);
                    ProgressBar progressBar = (ProgressBar) view3.findViewById(R.id.obfuscated_res_0x7f09191c);
                    bVar.f = progressBar;
                    this.d.add(progressBar);
                }
                view3.setTag(bVar);
            } else {
                view3 = view2;
                bVar = (b) view2.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.e) {
                    bVar.e.setVisibility(8);
                    bVar.d.setVisibility(8);
                    bVar.g.setVisibility(8);
                    bVar.h.setVisibility(8);
                } else {
                    if (!this.f && this.g == 0) {
                        bVar.d.setVisibility(8);
                    } else {
                        bVar.d.setVisibility(0);
                    }
                    bVar.e.setVisibility(0);
                    bVar.e.setTag(Integer.valueOf(i));
                    bVar.h.setVisibility(0);
                    bVar.g.setVisibility(8);
                    String portrait = this.a.get(i).getPortrait();
                    bVar.a.setImageDrawable(null);
                    bVar.a.K(portrait, 12, false);
                    bVar.b.setText(this.a.get(i).getName_show());
                    bVar.c.setText(this.a.get(i).getIntro());
                    bVar.d.setTag(Integer.valueOf(i));
                }
            } else {
                bVar.b.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a2e));
                bVar.f.setVisibility(0);
            }
            a(view3);
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (this.e) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }
}
