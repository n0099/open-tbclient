package d.a.r0.b0;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Queue<C1221b> f54818a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f54819b;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.r0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1221b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f54820a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.r0.a0.b f54821b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f54822c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.c.k.d.a f54823d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54824e;

        public C1221b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1221b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<Void, C1221b, C1221b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1221b> f54825a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f54826b;

        public c(b bVar, Queue<C1221b> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54826b = bVar;
            this.f54825a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1221b doInBackground(Void... voidArr) {
            int i2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (C1221b) invokeL.objValue;
            }
            while (true) {
                C1221b poll = this.f54825a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f54825a.add(poll);
                    return null;
                }
                d.a.c.k.d.a m = d.a.r0.a0.c.k().m(poll.f54820a.toCachedKey(poll.f54822c));
                if (m != null) {
                    poll.f54823d = m;
                    poll.f54824e = true;
                } else {
                    Bitmap f2 = this.f54826b.f(poll.f54820a, poll.f54822c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f54820a.getFilePath());
                            if (i2 != 0) {
                                try {
                                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(f2, i2);
                                    if (f2 != rotateBitmapBydegree) {
                                        try {
                                            f2.recycle();
                                            f2 = null;
                                        } catch (Exception unused) {
                                        }
                                    }
                                    bitmap = rotateBitmapBydegree;
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        if (i2 != 0 && bitmap != null) {
                            poll.f54823d = new d.a.c.k.d.a(bitmap, poll.f54820a.isGif(), poll.f54820a.getFilePath());
                        } else {
                            poll.f54823d = new d.a.c.k.d.a(f2, poll.f54820a.isGif(), poll.f54820a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1221b c1221b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1221b) == null) {
                super.onPostExecute(c1221b);
                this.f54826b.f54819b = null;
                this.f54826b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1221b... c1221bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1221bArr) == null) || c1221bArr == null) {
                return;
            }
            for (C1221b c1221b : c1221bArr) {
                d.a.c.k.d.a aVar = c1221b.f54823d;
                if (aVar != null && !c1221b.f54824e) {
                    d.a.r0.a0.c.k().d(c1221b.f54820a.toCachedKey(c1221b.f54822c), aVar);
                }
                d.a.r0.a0.b bVar = c1221b.f54821b;
                if (bVar != null) {
                    bVar.a(aVar, c1221b.f54820a.toCachedKey(c1221b.f54822c), c1221b.f54824e);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
                return;
            }
            super.onCancelled();
            this.f54826b.f54819b = null;
            while (true) {
                C1221b poll = this.f54825a.poll();
                if (poll == null) {
                    return;
                }
                d.a.r0.a0.b bVar = poll.f54821b;
                if (bVar != null) {
                    bVar.a(null, poll.f54820a.toCachedKey(poll.f54822c), false);
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54818a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54818a = new ConcurrentLinkedQueue();
            if (this.f54819b != null) {
                this.f54819b.cancel(true);
                this.f54819b = null;
            }
        }
    }

    public d.a.c.k.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return d.a.r0.a0.c.k().m(imageFileInfo.toCachedKey(z));
        }
        return (d.a.c.k.d.a) invokeLZ.objValue;
    }

    public d.a.c.k.d.a d(ImageFileInfo imageFileInfo, d.a.r0.a0.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, bVar, z)) == null) ? e(imageFileInfo, bVar, z, false) : (d.a.c.k.d.a) invokeLLZ.objValue;
    }

    public d.a.c.k.d.a e(ImageFileInfo imageFileInfo, d.a.r0.a0.b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            d.a.c.k.d.a c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            C1221b c1221b = new C1221b(this, null);
            c1221b.f54821b = bVar;
            c1221b.f54820a = imageFileInfo;
            c1221b.f54822c = z;
            this.f54818a.add(c1221b);
            g();
            return null;
        }
        return (d.a.c.k.d.a) invokeCommon.objValue;
    }

    public Bitmap f(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            if (z && imageFileInfo.getPersistActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPersistActionsList());
            }
            if (imageFileInfo.getPageActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPageActionsList());
            }
            if (imageFileInfo.getOrginalBitmap() != null) {
                try {
                    return d.a.r0.b0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else if (imageFileInfo.hasActions(z)) {
                try {
                    return d.a.r0.b0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            } else {
                return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
            }
        }
        return (Bitmap) invokeLZ.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f54819b == null && !this.f54818a.isEmpty()) {
            this.f54819b = new c(this, this.f54818a);
            this.f54819b.execute(new Void[0]);
        }
    }
}
