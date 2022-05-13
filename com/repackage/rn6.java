package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rn6 implements qn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;
    public final Context b;
    public String c;
    public String d;
    public boolean e;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ rn6 b;

        public a(rn6 rn6Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn6Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rn6Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                iu4.k().u("key_should_show_frs_new_tag", false);
                this.b.a.f.setVisibility(8);
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-36630663, "Lcom/repackage/rn6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-36630663, "Lcom/repackage/rn6$b;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.SPEED_ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.BRAND_LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BarImageView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public MessageRedDotView f;
        public ImageView g;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public static c a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                c cVar = new c();
                cVar.a = view2;
                cVar.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f09249b);
                cVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092499);
                cVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092496);
                cVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c98);
                cVar.f = (MessageRedDotView) view2.findViewById(R.id.obfuscated_res_0x7f091577);
                cVar.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09249f);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public rn6(@NonNull FrsFragment frsFragment, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = view2.getContext();
        c a2 = c.a(view2);
        this.a = a2;
        a2.b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.b.setPageId(frsFragment.getUniqueId());
        this.a.b.setContentDescription(view2.getResources().getString(R.string.obfuscated_res_0x7f0f02d7));
        this.a.b.setStrokeWith(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.a.b.setShowOval(true);
        this.a.b.setPlaceHolder(1);
        this.a.b.setTag(R.id.obfuscated_res_0x7f09065b, LogicField.INFO_AREA);
        this.a.c.setTag(R.id.obfuscated_res_0x7f09065b, LogicField.INFO_AREA);
        if (iu4.k().h("key_should_show_frs_new_tag", true)) {
            this.a.f.setEnterForumStyle(true);
            this.a.f.setFixMeasuredWidthHeight(true);
            this.a.f.g(view2.getResources().getString(R.string.obfuscated_res_0x7f0f067a), false);
            this.a.f.setVisibility(0);
        }
    }

    @Override // com.repackage.qn6
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            if (b.a[logicField.ordinal()] != 1) {
                return null;
            }
            return (T) this.a.g;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.repackage.qn6
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.e = z;
            this.a.e.setText(z ? this.d : this.c);
            this.a.g.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.repackage.qn6
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            a aVar = new a(this, onClickListener);
            this.a.b.setOnClickListener(aVar);
            this.a.c.setOnClickListener(aVar);
            this.a.e.setOnClickListener(onClickListener);
        }
    }

    @Override // com.repackage.qn6
    public void g(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            String format = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f09da), this.b.getString(R.string.obfuscated_res_0x7f0f0a73, Integer.valueOf(i)), str);
            this.d = format;
            if (this.e) {
                this.a.e.setText(format);
                this.a.e.setTag(R.id.obfuscated_res_0x7f09065b, LogicField.LEVEL_AND_LEVEL_NAME);
                this.a.g.setVisibility(0);
            }
        }
    }

    @Override // com.repackage.qn6
    public void j(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String format = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f02a4), StringHelper.numberUniformFormatExtraWithRoundInt(j), StringHelper.numberUniformFormatExtraWithRoundInt(j2));
            this.c = format;
            if (this.e) {
                return;
            }
            this.a.e.setText(format);
            this.a.e.setTag(R.id.obfuscated_res_0x7f09065b, null);
            this.a.g.setVisibility(8);
        }
    }

    @Override // com.repackage.qn6
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.a.b.K(str, 10, false);
            this.a.c.setText(str2);
        }
    }

    @Override // com.repackage.qn6
    public void l(@NonNull LogicField logicField, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, logicField, i) == null) {
            TextView textView = b.a[logicField.ordinal()] != 2 ? null : this.a.d;
            if (textView != null) {
                textView.setVisibility(i);
            }
        }
    }

    @Override // com.repackage.qn6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.b.setBorderWidth(mi.f(this.b, R.dimen.tbds1));
            this.a.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
            this.a.b.setStrokeColorResId(R.color.CAM_X0201);
            this.a.b.setPlaceHolder(1);
            this.a.b.invalidate();
            SkinManager.setViewTextColor(this.a.c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.a.e, (int) R.color.CAM_X0102);
        }
    }

    @NonNull
    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.a : (View) invokeV.objValue;
    }
}
