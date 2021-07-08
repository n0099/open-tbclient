package d.a.p0.h2.k.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.o0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.h2.k.g.e.b f57617a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f57618b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f57619c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f57620d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f57621e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f57622f;

    /* renamed from: g  reason: collision with root package name */
    public w f57623g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57624h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57625i;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57621e = new ArrayList();
        this.f57622f = null;
        this.f57624h = false;
        this.f57625i = true;
        this.f57619c = newSubPbActivity;
        this.f57620d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57624h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.p0.h2.k.g.e.b bVar = new d.a.p0.h2.k.g.e.b(this.f57619c, PostData.u0);
            this.f57617a = bVar;
            bVar.e(this.f57622f);
            this.f57617a.a0(this.f57623g);
            this.f57617a.setFromCDN(this.f57625i);
            this.f57621e.add(this.f57617a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f57619c, d.a.p0.h2.k.g.f.b.f57645f);
            this.f57618b = subPbReplyAdapter;
            this.f57621e.add(subPbReplyAdapter);
            this.f57621e.add(new d.a.p0.h2.k.g.e.c(this.f57619c, d.a.p0.h2.k.g.f.a.f57644e));
            this.f57620d.a(this.f57621e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f57620d.getAdapter2() == null) {
            return;
        }
        this.f57620d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f57622f = onClickListener;
        }
    }

    public void e(b2 b2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, b2Var, list) == null) {
            this.f57617a.w0(b2Var);
            if (!k.isEmpty(this.f57619c.getSubPbModel().c0())) {
                this.f57617a.v0(this.f57619c.getSubPbModel().c0());
            }
            NewSubPbActivity newSubPbActivity = this.f57619c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f57617a.t0(this.f57619c.getSubPbModel().u0());
            }
            this.f57620d.setData(list);
            this.f57620d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f57625i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f57624h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f57617a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xVar) == null) {
            this.f57617a.p(xVar);
        }
    }
}
