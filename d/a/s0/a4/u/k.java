package d.a.s0.a4.u;

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
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class k implements d.a.s0.a4.u.l.a, MultiImagePagerAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f57698a;

    /* renamed from: b  reason: collision with root package name */
    public j f57699b;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f57700c;

    /* renamed from: d  reason: collision with root package name */
    public int f57701d;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f57702e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.r0.r.s.a f57703f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f57704g;

    /* renamed from: h  reason: collision with root package name */
    public int f57705h;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f57706i;
    public int j;
    public HashMap<String, String> k;
    public PermissionJudgePolicy l;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f57707e;

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
            this.f57707e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getTag() == null) {
                return;
            }
            this.f57707e.f57700c.j(Integer.parseInt(view.getTag().toString()), this.f57707e.c());
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f57708e;

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
            this.f57708e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57708e.f57698a == null) {
                return;
            }
            Activity pageActivity = this.f57708e.f57698a.getPageActivity();
            if (this.f57708e.l == null) {
                this.f57708e.l = new PermissionJudgePolicy();
            }
            this.f57708e.l.clearRequestPermissionList();
            this.f57708e.l.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (this.f57708e.l.startRequestPermission(pageActivity)) {
                return;
            }
            this.f57708e.f57700c.g(false);
            if (this.f57708e.f57699b == null) {
                return;
            }
            if (this.f57708e.f57706i == null || this.f57708e.f57706i.getChosedFiles() == null || this.f57708e.f57706i.getChosedFiles().size() <= 0 || !this.f57708e.f57706i.isOriginalImg() || this.f57708e.f57705h <= 0 || !this.f57708e.o()) {
                this.f57708e.f57699b.k(true, this.f57708e.f57706i);
            } else {
                this.f57708e.f57699b.q();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f57710f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f57711g;

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
            this.f57711g = kVar;
            this.f57709e = i2;
            this.f57710f = z;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f57711g.f57703f != null) {
                    this.f57711g.f57703f.dismiss();
                }
                MultiImagePagerAdapter multiImagePagerAdapter = this.f57711g.f57700c;
                if (multiImagePagerAdapter != null) {
                    multiImagePagerAdapter.j(this.f57709e, this.f57710f);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f57712e;

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
            this.f57712e = kVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f57712e.f57703f == null) {
                return;
            }
            this.f57712e.f57703f.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f57713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f57714f;

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
            this.f57714f = kVar;
            this.f57713e = bitmap;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f57714f.f57703f != null) {
                    this.f57714f.f57703f.dismiss();
                }
                this.f57714f.f57699b.i(this.f57713e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f57715e;

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
            this.f57715e = kVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f57715e.f57703f == null) {
                return;
            }
            this.f57715e.f57703f.dismiss();
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
        this.f57700c = null;
        this.f57701d = 0;
        this.f57705h = 0;
        this.f57706i = null;
        this.j = TbadkCoreApplication.getInst().getSkinType();
        this.k = new HashMap<>();
        this.f57698a = tbPageContext;
        this.f57699b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57698a == null) {
            return;
        }
        if (!d.a.c.e.p.j.z()) {
            if (this.f57698a.getContext() != null) {
                l.L(this.f57698a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f57704g == null) {
            this.f57704g = new StickerModel(this.f57698a);
        }
        this.f57704g.LoadData();
        this.f57704g.x(this);
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
            j jVar = this.f57699b;
            return (jVar == null || (stickerLayout = jVar.f57689f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // d.a.s0.a4.u.l.a
    public void e(List<String> list) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (jVar = this.f57699b) == null) {
            return;
        }
        jVar.a(list);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f57705h++;
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f57706i;
            if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f57706i.getChosedFiles() != null && this.f57706i.getChosedFiles().size() != 0) {
                Iterator<ImageFileInfo> it = this.f57706i.getChosedFiles().iterator();
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (tbPageContext = this.f57698a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f57703f == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f57698a.getPageActivity());
            this.f57703f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f57703f.setPositiveButton(R.string.alert_yes_button, new c(this, i2, z));
            this.f57703f.setNegativeButton(R.string.cancel, new d(this));
            this.f57703f.create(this.f57698a);
        }
        this.f57703f.show();
    }

    public boolean q(Bitmap bitmap) {
        InterceptResult invokeL;
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            if (!this.f57700c.m() || (tbPageContext = this.f57698a) == null || tbPageContext.getPageActivity() == null) {
                return false;
            }
            if (this.f57703f == null) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f57698a.getPageActivity());
                this.f57703f = aVar;
                aVar.setMessageId(R.string.orginal_tip);
                this.f57703f.setPositiveButton(R.string.alert_yes_button, new e(this, bitmap));
                this.f57703f.setNegativeButton(R.string.cancel, new f(this));
                this.f57703f.create(this.f57698a);
            }
            this.f57703f.show();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (c()) {
                this.f57699b.f57688e.setmDisallowSlip(true);
            } else {
                this.f57699b.f57688e.setmDisallowSlip(false);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f57705h--;
        }
    }

    public void t() {
        StickerModel stickerModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (stickerModel = this.f57704g) == null) {
            return;
        }
        stickerModel.destroy();
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57701d : invokeV.intValue;
    }

    public ForumWriteData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f57702e : (ForumWriteData) invokeV.objValue;
    }

    public WriteImagesInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f57706i : (WriteImagesInfo) invokeV.objValue;
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
                this.f57701d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
                this.f57702e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
                this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            } else {
                TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f57698a;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f57698a.getPageActivity().getIntent()) == null) {
                    str = null;
                    i2 = -1;
                    if (str != null || i2 == -1) {
                    }
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                    this.f57706i = writeImagesInfo;
                    writeImagesInfo.parseJson(str);
                    z();
                    j jVar = this.f57699b;
                    if (jVar == null || jVar.f57688e == null) {
                        return;
                    }
                    MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f57698a.getOrignalPage(), this.f57699b.f57688e, this.f57706i.getChosedFiles(), i2, this, this.f57699b, this.f57706i.mIsFromIm);
                    this.f57700c = multiImagePagerAdapter;
                    this.f57699b.f57688e.setAdapter(multiImagePagerAdapter);
                    int l = this.f57700c.l();
                    this.f57699b.f57688e.setCurrentItem(l, true);
                    if (l == 0) {
                        this.f57700c.onPageSelected(0);
                    }
                    this.f57699b.p(this.f57706i);
                    return;
                }
                str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
                this.f57701d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
                this.f57702e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (jVar = this.f57699b) == null) {
            return;
        }
        d.a.s0.a4.t.c.b bVar = jVar.f57687d;
        if (bVar != null) {
            bVar.g(new a(this));
        }
        TextView textView = this.f57699b.f57690g;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (writeImagesInfo = this.f57706i) == null || !writeImagesInfo.isOriginalImg() || this.f57706i.getChosedFiles() == null || this.f57706i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f57706i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
