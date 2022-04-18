package com.repackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ea1;
import java.text.DecimalFormat;
import java.util.List;
/* loaded from: classes6.dex */
public class fa1 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ea1.a> a;
    public Context b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;
        public ImageView e;
        public LinearLayout f;
        public LinearLayout g;
        public TextView h;
        public ImageView i;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09070c);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09070b);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c66);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09059e);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09070d);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090709);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090706);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09070a);
            this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c70);
        }
    }

    public fa1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? new DecimalFormat("0").format((j * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public ea1.a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (ea1.a) invokeI.objValue;
    }

    public void c(List<ea1.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ea1.a> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            ea1.a item = getItem(i);
            if (item == null) {
                return view2;
            }
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0208, (ViewGroup) null, false);
                view2.setTag(new a(view2));
            }
            if (view2.getTag() != null && (view2.getTag() instanceof a)) {
                a aVar = (a) view2.getTag();
                if (item.a == -1) {
                    aVar.g.setVisibility(8);
                    aVar.f.setVisibility(0);
                    aVar.h.setText(item.d);
                    aVar.i.setSelected(item.h == 1);
                } else {
                    aVar.g.setVisibility(0);
                    aVar.f.setVisibility(8);
                    aVar.a.setText(item.d);
                    if (TextUtils.isEmpty(item.e)) {
                        aVar.b.setVisibility(8);
                    } else {
                        aVar.b.setVisibility(0);
                        aVar.b.setText(item.e);
                    }
                    aVar.c.setSelected(item.h == 1);
                    SpannableString spannableString = new SpannableString("￥" + a(item.g.longValue()));
                    spannableString.setSpan(new AbsoluteSizeSpan(g91.a(this.b, 14.0f)), 0, 1, 33);
                    aVar.d.setText(spannableString);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
