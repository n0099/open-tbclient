package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class iy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public my7 a;
    public SubPbReplyAdapter b;
    public NewSubPbActivity c;
    public BdTypeListView d;
    public List<ho> e;
    public View.OnClickListener f;
    public dp g;
    public boolean h;
    public boolean i;

    public iy7(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.f = null;
        this.h = false;
        this.i = true;
        this.c = newSubPbActivity;
        this.d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            my7 my7Var = new my7(this.c, PostData.x0);
            this.a = my7Var;
            my7Var.e(this.f);
            this.a.V(this.g);
            this.a.setFromCDN(this.i);
            this.e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.c, py7.b);
            this.b = subPbReplyAdapter;
            this.e.add(subPbReplyAdapter);
            this.e.add(new ny7(this.c, oy7.a));
            this.d.a(this.e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.d.getAdapter2() == null) {
            return;
        }
        this.d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void e(ThreadData threadData, List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, threadData, list) == null) {
            this.a.m0(threadData);
            if (!ni.isEmpty(this.c.getSubPbModel().r0())) {
                this.a.l0(this.c.getSubPbModel().r0());
            }
            NewSubPbActivity newSubPbActivity = this.c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.a.k0(this.c.getSubPbModel().M0());
            }
            this.d.setData(list);
            this.d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yVar) == null) {
            this.a.o(yVar);
        }
    }
}
