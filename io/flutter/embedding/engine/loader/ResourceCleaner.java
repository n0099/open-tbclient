package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes3.dex */
public class ResourceCleaner {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DELAY_MS = 5000;
    public static final String TAG = "ResourceCleaner";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;

    /* loaded from: classes3.dex */
    public static class CleanTask extends AsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final File[] mFilesToDelete;

        public CleanTask(File[] fileArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFilesToDelete = fileArr;
        }

        private void deleteRecursively(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, file) == null) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        deleteRecursively(file2);
                    }
                }
                file.delete();
            }
        }

        public boolean hasFilesToDelete() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                File[] fileArr = this.mFilesToDelete;
                return fileArr != null && fileArr.length > 0;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            File[] fileArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                for (File file : this.mFilesToDelete) {
                    if (file.exists()) {
                        deleteRecursively(file);
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public ResourceCleaner(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public void start() {
        File cacheDir;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cacheDir = this.mContext.getCacheDir()) == null) {
            return;
        }
        CleanTask cleanTask = new CleanTask(cacheDir.listFiles(new FilenameFilter(this) { // from class: io.flutter.embedding.engine.loader.ResourceCleaner.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResourceCleaner this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, str)) == null) ? str.startsWith(ResourcePaths.TEMPORARY_RESOURCE_PREFIX) : invokeLL.booleanValue;
            }
        }));
        if (cleanTask.hasFilesToDelete()) {
            new Handler().postDelayed(new Runnable(this, cleanTask) { // from class: io.flutter.embedding.engine.loader.ResourceCleaner.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ResourceCleaner this$0;
                public final /* synthetic */ CleanTask val$task;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cleanTask};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$task = cleanTask;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                }
            }, 5000L);
        }
    }
}
