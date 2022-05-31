package com.repackage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.model.StickerModel;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class fx8 implements gx8, MultiImagePagerAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteMultiImgsActivity> a;
    public ex8 b;
    public MultiImagePagerAdapter c;
    public int d;
    public ForumWriteData e;
    public dq4 f;
    public StickerModel g;
    public int h;
    public WriteImagesInfo i;
    public int j;
    public HashMap<String, String> k;
    public PermissionJudgePolicy l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx8 a;

        public a(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2.getTag() == null) {
                return;
            }
            this.a.c.j(Integer.parseInt(view2.getTag().toString()), this.a.c());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx8 a;

        public b(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            Activity pageActivity = this.a.a.getPageActivity();
            if (this.a.l == null) {
                this.a.l = new PermissionJudgePolicy();
            }
            this.a.l.clearRequestPermissionList();
            this.a.l.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.a.l.startRequestPermission(pageActivity)) {
                return;
            }
            this.a.c.h(false);
            if (this.a.b == null) {
                return;
            }
            if (this.a.i == null || this.a.i.getChosedFiles() == null || this.a.i.getChosedFiles().size() <= 0 || !this.a.i.isOriginalImg() || this.a.h <= 0 || !this.a.o()) {
                this.a.b.k(true, this.a.i);
            } else {
                this.a.b.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ fx8 c;

        public c(fx8 fx8Var, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fx8Var;
            this.a = i;
            this.b = z;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                if (this.c.f != null) {
                    this.c.f.dismiss();
                }
                MultiImagePagerAdapter multiImagePagerAdapter = this.c.c;
                if (multiImagePagerAdapter != null) {
                    multiImagePagerAdapter.j(this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx8 a;

        public d(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx8Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || this.a.f == null) {
                return;
            }
            this.a.f.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ fx8 b;

        public e(fx8 fx8Var, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx8Var;
            this.a = bitmap;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                if (this.b.f != null) {
                    this.b.f.dismiss();
                }
                this.b.b.i(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx8 a;

        public f(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx8Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || this.a.f == null) {
                return;
            }
            this.a.f.dismiss();
        }
    }

    public fx8(TbPageContext<WriteMultiImgsActivity> tbPageContext, ex8 ex8Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ex8Var, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = 0;
        this.h = 0;
        this.i = null;
        this.j = TbadkCoreApplication.getInst().getSkinType();
        this.k = new HashMap<>();
        this.a = tbPageContext;
        this.b = ex8Var;
        x(bundle);
        y();
        A();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        if (!ji.z()) {
            if (this.a.getContext() != null) {
                li.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c33);
                return;
            }
            return;
        }
        if (this.g == null) {
            this.g = new StickerModel(this.a);
        }
        this.g.loadData();
        this.g.z(this);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s();
            r(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            p(i, z);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public boolean c() {
        InterceptResult invokeV;
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ex8 ex8Var = this.b;
            return (ex8Var == null || (stickerLayout = ex8Var.f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.repackage.gx8
    public void e(List<String> list) {
        ex8 ex8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (ex8Var = this.b) == null) {
            return;
        }
        ex8Var.a(list);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h++;
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.i;
            if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.i.getChosedFiles() != null && this.i.getChosedFiles().size() != 0) {
                Iterator<ImageFileInfo> it = this.i.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.k.get(next.getFilePath()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(int i, boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f == null) {
            dq4 dq4Var = new dq4(this.a.getPageActivity());
            this.f = dq4Var;
            dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d00);
            this.f.setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new c(this, i, z));
            this.f.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new d(this));
            this.f.create(this.a);
        }
        this.f.show();
    }

    public boolean q(Bitmap bitmap) {
        InterceptResult invokeL;
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            if (!this.c.m() || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
                return false;
            }
            if (this.f == null) {
                dq4 dq4Var = new dq4(this.a.getPageActivity());
                this.f = dq4Var;
                dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0d00);
                this.f.setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new e(this, bitmap));
                this.f.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new f(this));
                this.f.create(this.a);
            }
            this.f.show();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (c()) {
                this.b.e.setmDisallowSlip(true);
            } else {
                this.b.e.setmDisallowSlip(false);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h--;
        }
    }

    public void t() {
        StickerModel stickerModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (stickerModel = this.g) == null) {
            return;
        }
        stickerModel.destroy();
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d : invokeV.intValue;
    }

    public ForumWriteData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e : (ForumWriteData) invokeV.objValue;
    }

    public WriteImagesInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i : (WriteImagesInfo) invokeV.objValue;
    }

    public final void x(Bundle bundle) {
        String str;
        int i;
        Intent intent;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            if (bundle != null) {
                str = bundle.getString(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_IMG_INFO);
                intExtra = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_CURRENT_INDEX);
                this.d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
                this.e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
                this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            } else {
                TbPageContext<WriteMultiImgsActivity> tbPageContext = this.a;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.a.getPageActivity().getIntent()) == null) {
                    str = null;
                    i = -1;
                    if (str != null || i == -1) {
                    }
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                    this.i = writeImagesInfo;
                    writeImagesInfo.parseJson(str);
                    z();
                    ex8 ex8Var = this.b;
                    if (ex8Var == null || ex8Var.e == null) {
                        return;
                    }
                    MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.a.getOrignalPage(), this.b.e, this.i.getChosedFiles(), i, this, this.b, this.i.mIsFromIm);
                    this.c = multiImagePagerAdapter;
                    this.b.e.setAdapter(multiImagePagerAdapter);
                    int l = this.c.l();
                    this.b.e.setCurrentItem(l, true);
                    if (l == 0) {
                        this.c.onPageSelected(0);
                    }
                    this.b.p(this.i);
                    return;
                }
                str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
                this.d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
                this.e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
                this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            }
            i = intExtra;
            if (str != null) {
            }
        }
    }

    public final void y() {
        ex8 ex8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (ex8Var = this.b) == null) {
            return;
        }
        tw8 tw8Var = ex8Var.d;
        if (tw8Var != null) {
            tw8Var.h(new a(this));
        }
        TextView textView = this.b.g;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (writeImagesInfo = this.i) == null || !writeImagesInfo.isOriginalImg() || this.i.getChosedFiles() == null || this.i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
