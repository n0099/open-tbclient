package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class yw7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<EmotionImageData> b;
    public Set<String> c;
    public vw7 d;
    public int e;
    public int f;
    public List<String> g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw7 a;

        public a(yw7 yw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tag = view2.getTag(view2.getId())) != null && (tag instanceof EmotionImageData)) {
                if (this.a.d != null && (view2 instanceof EmotionView)) {
                    this.a.d.a((EmotionImageData) tag, ((EmotionView) view2).getIsGif());
                }
                TiebaStatic.log("c12180");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw7 a;

        public b(yw7 yw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.a.c != null) {
                    for (String str : this.a.c) {
                        if (!TextUtils.isEmpty(str)) {
                            h35.k().h(str);
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EmotionView a;
        public EmotionView b;
        public EmotionView c;
        public EmotionView d;
        public final /* synthetic */ yw7 e;

        public c(yw7 yw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yw7Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.e(this.a);
                this.e.e(this.b);
                this.e.e(this.c);
                this.e.e(this.d);
            }
        }
    }

    public yw7(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdBaseApplication.getInst().getApp();
        this.b = list;
        this.c = new HashSet();
        this.f = oi.f(this.a, R.dimen.obfuscated_res_0x7f07023c);
        this.e = (int) (((oi.k(this.a) - oi.f(this.a, R.dimen.obfuscated_res_0x7f070309)) - (this.f * 4)) * 0.333d);
    }

    public final void d(EmotionView emotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, emotionView, emotionImageData) == null) || emotionView == null || emotionImageData == null) {
            return;
        }
        emotionView.setTag(emotionView.getId(), emotionImageData);
        emotionView.k0();
        emotionView.m0(emotionImageData);
        if (this.c == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        if (ListUtils.isEmpty(this.g) || !this.g.contains(emotionImageData.getThumbUrl())) {
            Set<String> set = this.c;
            set.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
        }
    }

    public final void e(EmotionView emotionView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionView) == null) || emotionView == null) {
            return;
        }
        emotionView.setOnClickListener(new a(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new b(this).execute(new Void[0]);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = null;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b.size() % 4 == 0) {
                return this.b.size() / 4;
            }
            return (this.b.size() / 4) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.b.get(i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                c cVar2 = new c(this);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0503, (ViewGroup) null);
                cVar2.a = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908be);
                cVar2.b = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908bf);
                cVar2.c = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908c0);
                cVar2.d = (EmotionView) inflate.findViewById(R.id.obfuscated_res_0x7f0908c1);
                cVar2.a();
                i(cVar2.b, this.e);
                i(cVar2.c, this.e);
                i(cVar2.d, this.e);
                inflate.setTag(cVar2);
                cVar = cVar2;
                view2 = inflate;
            } else {
                cVar = (c) view2.getTag();
            }
            int i2 = i * 4;
            int i3 = i2 + 4;
            int min = Math.min(i3, this.b.size() - 1);
            for (int i4 = i2; i4 < i3; i4++) {
                if (i4 <= min) {
                    EmotionImageData emotionImageData = this.b.get(i4);
                    int i5 = i4 - i2;
                    if (i5 == 0) {
                        d(cVar.a, emotionImageData);
                    } else if (i5 == 1) {
                        d(cVar.b, emotionImageData);
                    } else if (i5 == 2) {
                        d(cVar.c, emotionImageData);
                    } else if (i5 == 3) {
                        d(cVar.d, emotionImageData);
                    }
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.g = list;
        }
    }

    public final void i(View view2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) || view2 == null || view2.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        view2.setLayoutParams(marginLayoutParams);
    }

    public void j(vw7 vw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vw7Var) == null) {
            this.d = vw7Var;
        }
    }
}
