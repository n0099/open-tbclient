package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public View c;
    public Bitmap d;
    public ForumData e;
    public b f;
    public kw7 g;
    public PermissionJudgePolicy h;

    /* loaded from: classes6.dex */
    public class a extends ad5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ int b;
        public final /* synthetic */ mq6 c;

        public a(mq6 mq6Var, Bitmap bitmap, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq6Var, bitmap, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mq6Var;
            this.a = bitmap;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ad5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.e(this.a, this.b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b();
    }

    public mq6(TbPageContext tbPageContext, Context context, View view2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, context, view2, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = context;
        this.c = view2;
        this.f = bVar;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                return true;
            }
            if (this.h == null) {
                this.h = new PermissionJudgePolicy();
            }
            this.h.clearRequestPermissionList();
            this.h.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.h.startRequestPermission(this.a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
            g(this.d);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d == null) {
            b bVar = this.f;
            if (bVar != null) {
                bVar.a();
            }
            this.c.buildDrawingCache();
            this.d = this.c.getDrawingCache();
            b bVar2 = this.f;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    public final ShareItem e(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bitmap, i)) == null) {
            if (this.b == null || this.e == null) {
                return null;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.b0 = 1;
            shareItem.r = this.b.getString(R.string.obfuscated_res_0x7f0f029e);
            shareItem.s = "";
            shareItem.i(bitmap);
            shareItem.g();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_locate", 21);
            shareItem.k(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLI.objValue;
    }

    public /* synthetic */ void f(int i, ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a.getPageActivity(), i, shareItem, false));
    }

    public final void g(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) || this.a == null || b()) {
            return;
        }
        if (this.g == null) {
            this.g = new kw7(this.a);
        }
        ForumData forumData = this.e;
        this.g.b((forumData == null || TextUtils.isEmpty(forumData.forum_share_link)) ? "http://tieba.baidu.com" : this.e.forum_share_link, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void h(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumData) == null) {
            this.e = forumData;
        }
    }

    public final void i(Bitmap bitmap, final int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, bitmap, i) == null) || this.a == null || bitmap == null || b()) {
            return;
        }
        dd5.b(new a(this, bitmap, i), new ic5() { // from class: com.repackage.aq6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.repackage.ic5
            public final void onReturnDataInUI(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    mq6.this.f(i, (ShareItem) obj);
                }
            }
        });
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            d();
            i(this.d, i);
        }
    }
}
