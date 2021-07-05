package com.yy.hiidostatis.inner.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class UiThreadExecutor {
    public static /* synthetic */ Interceptable $ic;
    public static final Handler HANDLER;
    public static final Map<String, Token> TOKENS;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class Token {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String id;
        public int runnablesCount;

        public Token(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.runnablesCount = 0;
            this.id = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-108344247, "Lcom/yy/hiidostatis/inner/util/UiThreadExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-108344247, "Lcom/yy/hiidostatis/inner/util/UiThreadExecutor;");
                return;
            }
        }
        HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.yy.hiidostatis.inner.util.UiThreadExecutor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r7};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    Runnable callback = message.getCallback();
                    if (callback != null) {
                        callback.run();
                        UiThreadExecutor.decrementToken((Token) message.obj);
                        return;
                    }
                    super.handleMessage(message);
                }
            }
        };
        TOKENS = new HashMap();
    }

    public UiThreadExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void cancelAll(String str) {
        Token remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (TOKENS) {
                remove = TOKENS.remove(str);
            }
            if (remove == null) {
                return;
            }
            HANDLER.removeCallbacksAndMessages(remove);
        }
    }

    public static void decrementToken(Token token) {
        String str;
        Token remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, token) == null) {
            synchronized (TOKENS) {
                int i2 = token.runnablesCount - 1;
                token.runnablesCount = i2;
                if (i2 == 0 && (remove = TOKENS.remove((str = token.id))) != token) {
                    TOKENS.put(str, remove);
                }
            }
        }
    }

    public static Token nextToken(String str) {
        InterceptResult invokeL;
        Token token;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            synchronized (TOKENS) {
                token = TOKENS.get(str);
                if (token == null) {
                    token = new Token(str);
                    TOKENS.put(str, token);
                }
                token.runnablesCount++;
            }
            return token;
        }
        return (Token) invokeL.objValue;
    }

    public static void runTask(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, runnable) == null) {
            runTask(runnable, 0L);
        }
    }

    public static void runTask(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, null, runnable, j) == null) {
            runTask("", runnable, j);
        }
    }

    public static void runTask(String str, Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, runnable, Long.valueOf(j)}) == null) {
            if ("".equals(str)) {
                HANDLER.postDelayed(runnable, j);
            } else {
                HANDLER.postAtTime(runnable, nextToken(str), SystemClock.uptimeMillis() + j);
            }
        }
    }
}
