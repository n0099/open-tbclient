package com.repackage;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class yw8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinkedList<hu4> b;
    public LinkedList<ln4> c;
    public b d;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ yw8 b;

        public a(yw8 yw8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yw8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            hu4 g;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (g = this.b.g(this.a)) == null) {
                return;
            }
            if (this.b.d != null) {
                this.b.d.b(g.e());
            }
            if (this.b.d != null) {
                this.b.d.a(this.b.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<ln4> list);

        void b(int i);
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public View c;
        public TbImageView d;
        public TextView e;
        public ImageView f;
        public TextView g;
        public TextView h;
        public View i;

        public c(yw8 yw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(yw8 yw8Var, a aVar) {
            this(yw8Var);
        }
    }

    public yw8(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList<>();
        this.a = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.clear();
            if (ListUtils.isEmpty(this.b)) {
                return;
            }
            Iterator<hu4> it = this.b.iterator();
            while (it.hasNext()) {
                hu4 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        ln4 t = tbLinkSpanGroup.t();
                        t.p = tbLinkSpanGroup.f();
                        this.c.add(t);
                    }
                }
            }
            Collections.sort(this.c);
        }
    }

    public LinkedList<ln4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.c)) {
                return true;
            }
            Iterator<ln4> it = this.c.iterator();
            while (it.hasNext()) {
                ln4 next = it.next();
                if (next.b == 2 || !next.i) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<hu4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (LinkedList) invokeV.objValue;
    }

    public hu4 g(int i) {
        InterceptResult invokeI;
        LinkedList<hu4> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long itemId = getItemId(i);
            if (itemId != 0 && (linkedList = this.b) != null) {
                Iterator<hu4> it = linkedList.iterator();
                while (it.hasNext()) {
                    hu4 next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (hu4) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<ln4> linkedList = this.c;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<ln4> linkedList = this.c;
            if (linkedList == null || linkedList.size() <= i) {
                return null;
            }
            return this.c.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            LinkedList<ln4> linkedList = this.c;
            return (linkedList == null || linkedList.size() <= i || this.c.get(i) == null) ? 0 : this.c.get(i).a;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            ln4 ln4Var = (ln4) getItem(i);
            if (ln4Var == null) {
                return null;
            }
            if (view2 == null) {
                view3 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03e2, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.a = view3.findViewById(R.id.obfuscated_res_0x7f09067f);
                cVar.b = view3.findViewById(R.id.obfuscated_res_0x7f09067d);
                TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f09067b);
                cVar.d = tbImageView;
                tbImageView.setConrers(15);
                cVar.d.setRadius(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                cVar.d.setPlaceHolderAutoChangeSkinType(1);
                cVar.d.setGifIconSupport(false);
                cVar.d.setLongIconSupport(false);
                cVar.d.setDrawBorder(true);
                cVar.d.setBorderWidth(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                cVar.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                cVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f09067a);
                cVar.f = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090679);
                cVar.c = view3.findViewById(R.id.obfuscated_res_0x7f09092a);
                cVar.g = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f09067e);
                cVar.h = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090678);
                cVar.i = view3.findViewById(R.id.obfuscated_res_0x7f090680);
                view3.setTag(cVar);
            } else {
                cVar = (c) view2.getTag();
                view3 = view2;
            }
            cVar.d.K(ln4Var.e, 10, false);
            if (TextUtils.isEmpty(ln4Var.f)) {
                cVar.c.setVisibility(8);
                cVar.e.setMaxLines(2);
            } else {
                cVar.c.setVisibility(0);
                cVar.e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(ln4Var.f)) {
                cVar.g.setVisibility(8);
            } else {
                cVar.g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0412), ln4Var.f));
                cVar.g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(ln4Var.l)) {
                spannableStringBuilder.append((CharSequence) ln4Var.l);
                int f = li.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f2 = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int f3 = li.f(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int f4 = li.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f5 = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f6 = li.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                bt4 bt4Var = new bt4(f, -1, R.color.CAM_X0305, f3, R.color.CAM_X0305, f4, li.f(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bt4Var.b(f2);
                bt4Var.h(f5);
                bt4Var.i(f6);
                spannableStringBuilder.setSpan(bt4Var, 0, ln4Var.l.length(), 17);
            }
            if (!ln4Var.n && ln4Var.b != 2 && !ln4Var.i) {
                String str = ln4Var.g;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.e.setMaxLines(1);
            } else {
                String str2 = ln4Var.c;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.e.setText(spannableStringBuilder);
            cVar.f.setOnClickListener(new a(this, i));
            li.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            SkinManager.setBackgroundShapeDrawable(cVar.a, 0, R.color.CAM_X0205, R.color.CAM_X0205);
            wq4 d = wq4.d(cVar.b);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0206);
            cVar.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080802, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.g, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(cVar.h, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c();
            notifyDataSetChanged();
        }
    }

    public void i(LinkedList<hu4> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.b = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.d = bVar;
        }
    }
}
