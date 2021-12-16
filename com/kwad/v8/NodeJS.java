package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public class NodeJS {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GLOBAL = "global";
    public static final String NEXT_TICK = "nextTick";
    public static final String NODE = "node";
    public static final String PROCESS = "process";
    public static final String STARTUP_CALLBACK = "__run";
    public static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
    public static final String STARTUP_SCRIPT_NAME = "startup";
    public static final String TMP_JS_EXT = ".js.tmp";
    public static final String VERSIONS = "versions";
    public transient /* synthetic */ FieldHolder $fh;
    public String nodeVersion;
    public V8Function require;
    public V8 v8;

    public NodeJS(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nodeVersion = null;
        this.v8 = v8;
    }

    public static NodeJS createNodeJS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? createNodeJS(null) : (NodeJS) invokeV.objValue;
    }

    public static NodeJS createNodeJS(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            V8 createV8Runtime = V8.createV8Runtime(GLOBAL);
            NodeJS nodeJS = new NodeJS(createV8Runtime);
            createV8Runtime.registerJavaMethod(new JavaVoidCallback(nodeJS) { // from class: com.kwad.v8.NodeJS.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NodeJS val$node;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nodeJS};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$node = nodeJS;
                }

                @Override // com.kwad.v8.JavaVoidCallback
                public void invoke(V8Object v8Object, V8Array v8Array) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, v8Object, v8Array) == null) {
                        V8Function v8Function = (V8Function) v8Array.get(0);
                        try {
                            this.val$node.init(v8Function.twin());
                        } finally {
                            v8Function.close();
                        }
                    }
                }
            }, STARTUP_CALLBACK);
            try {
                File createTemporaryScriptFile = createTemporaryScriptFile(STARTUP_SCRIPT, STARTUP_SCRIPT_NAME);
                createV8Runtime.createNodeRuntime(createTemporaryScriptFile.getAbsolutePath());
                createTemporaryScriptFile.delete();
                if (file != null) {
                    nodeJS.exec(file);
                }
                return nodeJS;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (NodeJS) invokeL.objValue;
    }

    private V8Function createScriptExecutionCallback(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, file)) == null) ? new V8Function(this.v8, new JavaCallback(this, file) { // from class: com.kwad.v8.NodeJS.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NodeJS this$0;
            public final /* synthetic */ File val$file;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, file};
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
                this.val$file = file;
            }

            @Override // com.kwad.v8.JavaCallback
            public Object invoke(V8Object v8Object, V8Array v8Array) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, v8Object, v8Array)) == null) {
                    V8Array v8Array2 = new V8Array(this.this$0.v8);
                    try {
                        v8Array2.push(this.val$file.getAbsolutePath());
                        return this.this$0.require.call(null, v8Array2);
                    } finally {
                        v8Array2.close();
                    }
                }
                return invokeLL.objValue;
            }
        }) : (V8Function) invokeL.objValue;
    }

    public static File createTemporaryScriptFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            File createTempFile = File.createTempFile(str2, TMP_JS_EXT);
            PrintWriter printWriter = new PrintWriter(createTempFile, "UTF-8");
            try {
                printWriter.print(str);
                return createTempFile;
            } finally {
                printWriter.close();
            }
        }
        return (File) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init(V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, v8Function) == null) {
            this.require = v8Function;
        }
    }

    private void safeRelease(Releasable releasable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, releasable) == null) || releasable == null) {
            return;
        }
        releasable.release();
    }

    public void exec(File file) {
        V8Array v8Array;
        Throwable th;
        V8Object v8Object;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, file) != null) {
            return;
        }
        V8Function createScriptExecutionCallback = createScriptExecutionCallback(file);
        try {
            v8Object = this.v8.getObject("process");
            try {
                v8Array = new V8Array(this.v8);
                try {
                    v8Array.push((V8Value) createScriptExecutionCallback);
                    v8Object.executeObjectFunction(NEXT_TICK, v8Array);
                    safeRelease(v8Object);
                    safeRelease(v8Array);
                    safeRelease(createScriptExecutionCallback);
                } catch (Throwable th2) {
                    th = th2;
                    safeRelease(v8Object);
                    safeRelease(v8Array);
                    safeRelease(createScriptExecutionCallback);
                    throw th;
                }
            } catch (Throwable th3) {
                v8Array = null;
                th = th3;
            }
        } catch (Throwable th4) {
            v8Array = null;
            th = th4;
            v8Object = null;
        }
    }

    public String getNodeVersion() {
        InterceptResult invokeV;
        Releasable releasable;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
            return (String) invokeV.objValue;
        }
        String str = this.nodeVersion;
        if (str != null) {
            return str;
        }
        V8Object v8Object = null;
        try {
            V8Object object = this.v8.getObject("process");
            try {
                v8Object = object.getObject("versions");
                this.nodeVersion = v8Object.getString(NODE);
                safeRelease(object);
                safeRelease(v8Object);
                return this.nodeVersion;
            } catch (Throwable th) {
                th = th;
                releasable = v8Object;
                v8Object = object;
                safeRelease(v8Object);
                safeRelease(releasable);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            releasable = null;
        }
    }

    public V8 getRuntime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.v8 : (V8) invokeV.objValue;
    }

    public boolean handleMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.v8.checkThread();
            return this.v8.pumpMessageLoop();
        }
        return invokeV.booleanValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.v8.checkThread();
            return this.v8.isRunning();
        }
        return invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.v8.checkThread();
            if (!this.require.isReleased()) {
                this.require.close();
            }
            if (this.v8.isReleased()) {
                return;
            }
            this.v8.close();
        }
    }

    public V8Object require(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, file)) == null) {
            this.v8.checkThread();
            V8Array v8Array = new V8Array(this.v8);
            try {
                v8Array.push(file.getAbsolutePath());
                return (V8Object) this.require.call(null, v8Array);
            } finally {
                v8Array.close();
            }
        }
        return (V8Object) invokeL.objValue;
    }
}
