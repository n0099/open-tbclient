package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class je7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<he7> a;
    public Context b;
    public int c;
    public int d;
    public final int e;

    public je7(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.c = 0;
        this.d = 0;
        this.b = context;
        this.c = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
        this.e = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public he7 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (he7) invokeI.objValue;
    }

    public void b(List<he7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a.clear();
            if (list != null && list.size() > 0) {
                this.a.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (view2 instanceof TextView) {
                textView = (TextView) view2;
            } else {
                textView = new TextView(this.b);
                textView.setGravity(17);
                textView.setTextSize(0, this.c);
                int i2 = this.d;
                textView.setPadding(0, i2, 0, i2);
            }
            he7 he7Var = (he7) ListUtils.getItem(this.a, i);
            if (he7Var == null) {
                return null;
            }
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(he7Var.c, 8, (String) null));
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            if (i == this.e) {
                SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
            } else {
                SkinManager.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
            }
            return textView;
        }
        return (View) invokeILL.objValue;
    }
}
