package d.a.q0.a4.u;

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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class k implements d.a.q0.a4.u.l.a, MultiImagePagerAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f54987a;

    /* renamed from: b  reason: collision with root package name */
    public j f54988b;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f54989c;

    /* renamed from: d  reason: collision with root package name */
    public int f54990d;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f54991e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.s.s.a f54992f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f54993g;

    /* renamed from: h  reason: collision with root package name */
    public int f54994h;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f54995i;
    public int j;
    public HashMap<String, String> k;
    public PermissionJudgePolicy l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f54996e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54996e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getTag() == null) {
                return;
            }
            this.f54996e.f54989c.j(Integer.parseInt(view.getTag().toString()), this.f54996e.c());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f54997e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54997e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54997e.f54987a == null) {
                return;
            }
            Activity pageActivity = this.f54997e.f54987a.getPageActivity();
            if (this.f54997e.l == null) {
                this.f54997e.l = new PermissionJudgePolicy();
            }
            this.f54997e.l.clearRequestPermissionList();
            this.f54997e.l.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (this.f54997e.l.startRequestPermission(pageActivity)) {
                return;
            }
            this.f54997e.f54989c.h(false);
            if (this.f54997e.f54988b == null) {
                return;
            }
            if (this.f54997e.f54995i == null || this.f54997e.f54995i.getChosedFiles() == null || this.f54997e.f54995i.getChosedFiles().size() <= 0 || !this.f54997e.f54995i.isOriginalImg() || this.f54997e.f54994h <= 0 || !this.f54997e.o()) {
                this.f54997e.f54988b.k(true, this.f54997e.f54995i);
            } else {
                this.f54997e.f54988b.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54998e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54999f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f55000g;

        public c(k kVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55000g = kVar;
            this.f54998e = i2;
            this.f54999f = z;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f55000g.f54992f != null) {
                    this.f55000g.f54992f.dismiss();
                }
                MultiImagePagerAdapter multiImagePagerAdapter = this.f55000g.f54989c;
                if (multiImagePagerAdapter != null) {
                    multiImagePagerAdapter.j(this.f54998e, this.f54999f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f55001e;

        public d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55001e = kVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f55001e.f54992f == null) {
                return;
            }
            this.f55001e.f54992f.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f55002e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f55003f;

        public e(k kVar, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55003f = kVar;
            this.f55002e = bitmap;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f55003f.f54992f != null) {
                    this.f55003f.f54992f.dismiss();
                }
                this.f55003f.f54988b.i(this.f55002e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f55004e;

        public f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55004e = kVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f55004e.f54992f == null) {
                return;
            }
            this.f55004e.f54992f.dismiss();
        }
    }

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, jVar, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54989c = null;
        this.f54990d = 0;
        this.f54994h = 0;
        this.f54995i = null;
        this.j = TbadkCoreApplication.getInst().getSkinType();
        this.k = new HashMap<>();
        this.f54987a = tbPageContext;
        this.f54988b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54987a == null) {
            return;
        }
        if (!d.a.d.e.p.j.z()) {
            if (this.f54987a.getContext() != null) {
                l.L(this.f54987a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f54993g == null) {
            this.f54993g = new StickerModel(this.f54987a);
        }
        this.f54993g.LoadData();
        this.f54993g.x(this);
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
    public void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            p(i2, z);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public boolean c() {
        InterceptResult invokeV;
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            j jVar = this.f54988b;
            return (jVar == null || (stickerLayout = jVar.f54978f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // d.a.q0.a4.u.l.a
    public void e(List<String> list) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (jVar = this.f54988b) == null) {
            return;
        }
        jVar.a(list);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f54994h++;
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f54995i;
            if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f54995i.getChosedFiles() != null && this.f54995i.getChosedFiles().size() != 0) {
                Iterator<ImageFileInfo> it = this.f54995i.getChosedFiles().iterator();
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

    public final void p(int i2, boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (tbPageContext = this.f54987a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f54992f == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f54987a.getPageActivity());
            this.f54992f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f54992f.setPositiveButton(R.string.alert_yes_button, new c(this, i2, z));
            this.f54992f.setNegativeButton(R.string.cancel, new d(this));
            this.f54992f.create(this.f54987a);
        }
        this.f54992f.show();
    }

    public boolean q(Bitmap bitmap) {
        InterceptResult invokeL;
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            if (!this.f54989c.m() || (tbPageContext = this.f54987a) == null || tbPageContext.getPageActivity() == null) {
                return false;
            }
            if (this.f54992f == null) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f54987a.getPageActivity());
                this.f54992f = aVar;
                aVar.setMessageId(R.string.orginal_tip);
                this.f54992f.setPositiveButton(R.string.alert_yes_button, new e(this, bitmap));
                this.f54992f.setNegativeButton(R.string.cancel, new f(this));
                this.f54992f.create(this.f54987a);
            }
            this.f54992f.show();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (c()) {
                this.f54988b.f54977e.setmDisallowSlip(true);
            } else {
                this.f54988b.f54977e.setmDisallowSlip(false);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f54994h--;
        }
    }

    public void t() {
        StickerModel stickerModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (stickerModel = this.f54993g) == null) {
            return;
        }
        stickerModel.destroy();
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f54990d : invokeV.intValue;
    }

    public ForumWriteData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f54991e : (ForumWriteData) invokeV.objValue;
    }

    public WriteImagesInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f54995i : (WriteImagesInfo) invokeV.objValue;
    }

    public final void x(Bundle bundle) {
        String str;
        int i2;
        Intent intent;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            if (bundle != null) {
                str = bundle.getString(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_IMG_INFO);
                intExtra = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_CURRENT_INDEX);
                this.f54990d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
                this.f54991e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
                this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            } else {
                TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f54987a;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f54987a.getPageActivity().getIntent()) == null) {
                    str = null;
                    i2 = -1;
                    if (str != null || i2 == -1) {
                    }
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                    this.f54995i = writeImagesInfo;
                    writeImagesInfo.parseJson(str);
                    z();
                    j jVar = this.f54988b;
                    if (jVar == null || jVar.f54977e == null) {
                        return;
                    }
                    MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f54987a.getOrignalPage(), this.f54988b.f54977e, this.f54995i.getChosedFiles(), i2, this, this.f54988b, this.f54995i.mIsFromIm);
                    this.f54989c = multiImagePagerAdapter;
                    this.f54988b.f54977e.setAdapter(multiImagePagerAdapter);
                    int l = this.f54989c.l();
                    this.f54988b.f54977e.setCurrentItem(l, true);
                    if (l == 0) {
                        this.f54989c.onPageSelected(0);
                    }
                    this.f54988b.p(this.f54995i);
                    return;
                }
                str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
                this.f54990d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
                this.f54991e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
                this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            }
            i2 = intExtra;
            if (str != null) {
            }
        }
    }

    public final void y() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (jVar = this.f54988b) == null) {
            return;
        }
        d.a.q0.a4.t.c.b bVar = jVar.f54976d;
        if (bVar != null) {
            bVar.g(new a(this));
        }
        TextView textView = this.f54988b.f54979g;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (writeImagesInfo = this.f54995i) == null || !writeImagesInfo.isOriginalImg() || this.f54995i.getChosedFiles() == null || this.f54995i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f54995i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
