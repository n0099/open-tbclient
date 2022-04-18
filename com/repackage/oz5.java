package com.repackage;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jz5;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class oz5 implements jz5.a {
    public static /* synthetic */ Interceptable $ic;
    public static oz5 j;
    public transient /* synthetic */ FieldHolder $fh;
    public jz5 a;
    public jz5 b;
    public ArrayList<TransmitForumData> c;
    public ArrayList<TransmitForumData> d;
    public boolean e;
    public ArrayList<TransmitForumData> f;
    public boolean g;
    public int h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755422393, "Lcom/repackage/oz5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755422393, "Lcom/repackage/oz5;");
        }
    }

    public oz5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList<>();
        this.e = false;
        this.g = false;
        this.i = false;
        e();
    }

    public static Location b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public static oz5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (j == null) {
                synchronized (oz5.class) {
                    if (j == null) {
                        j = new oz5();
                    }
                }
            }
            return j;
        }
        return (oz5) invokeV.objValue;
    }

    @Override // com.repackage.jz5.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (i == 1) {
                if (z) {
                    this.f = arrayList;
                }
                this.g = true;
            } else if (i == 2) {
                if (z) {
                    this.d = arrayList;
                    this.h = i2;
                }
                this.e = true;
            }
            j();
        }
    }

    public final Location d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() : (Location) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            f();
            this.i = false;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), jz5.class);
            if (runTask != null) {
                this.b = (jz5) runTask.getData();
            }
            jz5 jz5Var = this.b;
            if (jz5Var != null) {
                jz5Var.a(this);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), jz5.class);
            if (runTask != null) {
                this.a = (jz5) runTask.getData();
            }
            jz5 jz5Var = this.a;
            if (jz5Var != null) {
                jz5Var.a(this);
            }
        }
    }

    public final boolean h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            ArrayList<TransmitForumData> arrayList = this.c;
            if (arrayList == null) {
                return false;
            }
            Iterator<TransmitForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                TransmitForumData next = it.next();
                if (next != null && next.forumId == j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i = true;
            jz5 jz5Var = this.a;
            if (jz5Var != null) {
                jz5Var.b();
            }
            jz5 jz5Var2 = this.b;
            if (jz5Var2 != null) {
                jz5Var2.b();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.a == null || this.e) {
                if (this.b == null || this.g) {
                    this.e = false;
                    this.g = false;
                    this.i = false;
                    this.c.clear();
                    if (!ListUtils.isEmpty(this.d)) {
                        Iterator<TransmitForumData> it = this.d.iterator();
                        while (it.hasNext()) {
                            TransmitForumData next = it.next();
                            if (!h(next.forumId)) {
                                this.c.add(next);
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.f)) {
                        Iterator<TransmitForumData> it2 = this.f.iterator();
                        while (it2.hasNext()) {
                            TransmitForumData next2 = it2.next();
                            if (!h(next2.forumId)) {
                                this.c.add(next2);
                            }
                        }
                    }
                    this.d = null;
                    this.f = null;
                    k();
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.c));
        }
    }

    public void l(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareDialogConfig) == null) || shareDialogConfig == null || shareDialogConfig.shareItem == null || fc5.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.B = d();
        }
        if (oi.C() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.i && !shareDialogConfig.shareItem.f()) {
            i();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.c);
        shareDialogConfig.setPrivateThread(this.h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
