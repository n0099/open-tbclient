package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class vl7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImageFileInfo> a;
    public LinkedHashMap<String, ImageFileInfo> b;
    public x25 c;
    public BaseFragmentActivity d;
    public ul7 e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public String l;

    /* loaded from: classes7.dex */
    public class a implements t25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public a(vl7 vl7Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl7Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
        }

        @Override // com.repackage.t25
        public void a(um umVar, String str, boolean z) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, umVar, str, z) == null) || (headImageView = (HeadImageView) this.a.findViewWithTag(str)) == null || umVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public HeadImageView b;
        public ImageView c;
        public final /* synthetic */ vl7 d;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getTag(view2.getId()) != null && (view2.getTag(view2.getId()) instanceof ImageFileInfo)) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) view2.getTag(view2.getId());
                    if (this.a.d.b.containsKey(imageFileInfo.getFilePath())) {
                        this.a.d.b.remove(imageFileInfo.getFilePath());
                        SkinManager.setBackgroundResource(this.a.c, R.drawable.obfuscated_res_0x7f08063f);
                        if (this.a.d.e != null) {
                            this.a.d.e.onUnChoose();
                        }
                    } else if (this.a.d.e != null) {
                        if (this.a.d.e.canChooseMore()) {
                            this.a.d.b.put(imageFileInfo.getFilePath(), imageFileInfo);
                            SkinManager.setBackgroundResource(this.a.c, R.drawable.obfuscated_res_0x7f080640);
                            this.a.d.e.onChoose();
                            return;
                        }
                        Activity pageActivity = this.a.d.d.getPageContext().getPageActivity();
                        if (!TextUtils.isEmpty(this.a.d.l)) {
                            BdToast.c(pageActivity, this.a.d.l).n();
                        } else {
                            BdToast.c(pageActivity, pageActivity.getText(R.string.obfuscated_res_0x7f0f05de)).n();
                        }
                    }
                }
            }
        }

        public b(vl7 vl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vl7Var;
        }

        public final void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e34);
                this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c5d);
                view2.setOnClickListener(new a(this));
            }
        }
    }

    public vl7(BaseFragmentActivity baseFragmentActivity, List<ImageFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = baseFragmentActivity;
        this.a = list;
        this.b = new LinkedHashMap<>();
        this.f = (int) baseFragmentActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f07027d);
        int k = li.k(baseFragmentActivity.getPageContext().getPageActivity());
        this.g = k;
        this.h = (k - li.f(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be)) / 3;
        int f = li.f(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070305) / 3;
        this.i = f;
        this.j = (f * 2) + 1;
        this.c = new x25();
    }

    public void e(Map<String, ImageFileInfo> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            this.b.putAll(map);
        }
    }

    public LinkedHashMap<String, ImageFileInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (LinkedHashMap) invokeV.objValue;
    }

    public x25 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (x25) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ImageFileInfo> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
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
        View view3;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                bVar = new b(this);
                view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04e2, (ViewGroup) null);
                bVar.b(view3);
                view3.setTag(bVar);
            } else {
                view3 = view2;
                bVar = (b) view2.getTag();
            }
            bVar.a = view3;
            int paddingTop = view3.getPaddingTop();
            int i2 = i % 3;
            if (i2 == 0) {
                bVar.a.setPadding(0, paddingTop, this.j, 0);
            } else if (i2 == 1) {
                View view4 = bVar.a;
                int i3 = this.i;
                view4.setPadding(i3, paddingTop, i3, 0);
            } else {
                bVar.a.setPadding(this.j, paddingTop, 0, 0);
            }
            bVar.b.getLayoutParams().height = this.h;
            bVar.b.setTag(null);
            bVar.b.setRadius(1);
            bVar.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080ba6);
            bVar.b.K(null, 12, false);
            bVar.b.invalidate();
            ImageFileInfo imageFileInfo = this.a.get(i);
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                int i4 = this.f;
                imageFileInfo.addPageAction(g35.g(i4, i4));
                um c = this.c.c(imageFileInfo, false);
                bVar.b.setTag(imageFileInfo.toCachedKey(false));
                if (c != null) {
                    bVar.b.invalidate();
                } else {
                    this.c.e(imageFileInfo, new a(this, viewGroup), false, this.k);
                }
                if (this.b.containsKey(imageFileInfo.getFilePath())) {
                    SkinManager.setBackgroundResource(bVar.c, R.drawable.obfuscated_res_0x7f080640);
                } else {
                    SkinManager.setBackgroundResource(bVar.c, R.drawable.obfuscated_res_0x7f08063f);
                }
                view3.setTag(view3.getId(), imageFileInfo);
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: h */
    public ImageFileInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<ImageFileInfo> list = this.a;
            if (list == null || i > list.size() - 1) {
                return null;
            }
            return this.a.get(i);
        }
        return (ImageFileInfo) invokeI.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void j(ul7 ul7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ul7Var) == null) {
            this.e = ul7Var;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }
}
