package org.chromium.base;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.base.annotations.MainDex;
@MainDex
/* loaded from: classes2.dex */
public abstract class CommandLine {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String SWITCH_PREFIX = "--";
    public static final String SWITCH_TERMINATOR = "--";
    public static final String SWITCH_VALUE_SEPARATOR = "=";
    public static final String TAG = "CommandLine";
    public static final AtomicReference<CommandLine> sCommandLine = new AtomicReference<>();

    /* loaded from: classes2.dex */
    public interface Natives {
        void appendSwitch(String str);

        void appendSwitchWithValue(String str, String str2);

        void appendSwitchesAndArguments(String[] strArr);

        String getSwitchValue(String str);

        String[] getSwitchesFlattened();

        boolean hasSwitch(String str);

        void init(String[] strArr);

        void removeSwitch(String str);
    }

    public abstract void appendSwitch(String str);

    public abstract void appendSwitchWithValue(String str, String str2);

    public abstract void appendSwitchesAndArguments(String[] strArr);

    public void destroy() {
    }

    public abstract String[] getCommandLineArguments();

    public abstract String getSwitchValue(String str);

    public abstract Map getSwitches();

    public abstract boolean hasSwitch(String str);

    public boolean isNativeImplementation() {
        return false;
    }

    public abstract void removeSwitch(String str);

    /* loaded from: classes2.dex */
    public static class JavaCommandLine extends CommandLine {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public ArrayList<String> mArgs;
        public int mArgsBegin;
        public HashMap<String, String> mSwitches;

        public JavaCommandLine(@Nullable String[] strArr) {
            super();
            this.mSwitches = new HashMap<>();
            ArrayList<String> arrayList = new ArrayList<>();
            this.mArgs = arrayList;
            this.mArgsBegin = 1;
            if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                arrayList.add(strArr[0]);
                appendSwitchesInternal(strArr, 1);
                return;
            }
            this.mArgs.add("");
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitch(String str) {
            appendSwitchWithValue(str, null);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] strArr) {
            appendSwitchesInternal(strArr, 0);
        }

        @Override // org.chromium.base.CommandLine
        public String getSwitchValue(String str) {
            String str2 = this.mSwitches.get(str);
            if (str2 == null || str2.isEmpty()) {
                return null;
            }
            return str2;
        }

        @Override // org.chromium.base.CommandLine
        public boolean hasSwitch(String str) {
            return this.mSwitches.containsKey(str);
        }

        private void appendSwitchesInternal(String[] strArr, int i) {
            String str;
            boolean z = true;
            for (String str2 : strArr) {
                if (i > 0) {
                    i--;
                } else {
                    if (str2.equals("--")) {
                        z = false;
                    }
                    if (z && str2.startsWith("--")) {
                        String[] split = str2.split("=", 2);
                        if (split.length > 1) {
                            str = split[1];
                        } else {
                            str = null;
                        }
                        appendSwitchWithValue(split[0].substring(2), str);
                    } else {
                        this.mArgs.add(str2);
                    }
                }
            }
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchWithValue(String str, String str2) {
            String str3;
            HashMap<String, String> hashMap = this.mSwitches;
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
            }
            hashMap.put(str, str3);
            String str4 = "--" + str;
            if (str2 != null && !str2.isEmpty()) {
                str4 = str4 + "=" + str2;
            }
            ArrayList<String> arrayList = this.mArgs;
            int i = this.mArgsBegin;
            this.mArgsBegin = i + 1;
            arrayList.add(i, str4);
        }

        @Override // org.chromium.base.CommandLine
        public String[] getCommandLineArguments() {
            ArrayList<String> arrayList = this.mArgs;
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @Override // org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            return new HashMap(this.mSwitches);
        }

        @Override // org.chromium.base.CommandLine
        public void removeSwitch(String str) {
            this.mSwitches.remove(str);
            String str2 = "--" + str;
            for (int i = this.mArgsBegin - 1; i > 0; i--) {
                if (!this.mArgs.get(i).equals(str2)) {
                    if (!this.mArgs.get(i).startsWith(str2 + "=")) {
                    }
                }
                this.mArgsBegin--;
                this.mArgs.remove(i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class NativeCommandLine extends CommandLine {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // org.chromium.base.CommandLine
        public String[] getCommandLineArguments() {
            return null;
        }

        @Override // org.chromium.base.CommandLine
        public boolean isNativeImplementation() {
            return true;
        }

        public NativeCommandLine(@Nullable String[] strArr) {
            super();
            CommandLineJni.get().init(strArr);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitch(String str) {
            CommandLineJni.get().appendSwitch(str);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] strArr) {
            CommandLineJni.get().appendSwitchesAndArguments(strArr);
        }

        @Override // org.chromium.base.CommandLine
        public String getSwitchValue(String str) {
            return CommandLineJni.get().getSwitchValue(str);
        }

        @Override // org.chromium.base.CommandLine
        public boolean hasSwitch(String str) {
            return CommandLineJni.get().hasSwitch(str);
        }

        @Override // org.chromium.base.CommandLine
        public void removeSwitch(String str) {
            CommandLineJni.get().removeSwitch(str);
        }

        @Override // org.chromium.base.CommandLine
        public void appendSwitchWithValue(String str, String str2) {
            Natives natives = CommandLineJni.get();
            if (str2 == null) {
                str2 = "";
            }
            natives.appendSwitchWithValue(str, str2);
        }

        @Override // org.chromium.base.CommandLine
        public void destroy() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }

        @Override // org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            HashMap hashMap = new HashMap();
            String[] switchesFlattened = CommandLineJni.get().getSwitchesFlattened();
            for (int i = 0; i < switchesFlattened.length; i += 2) {
                hashMap.put(switchesFlattened[i], switchesFlattened[i + 1]);
            }
            return hashMap;
        }
    }

    public CommandLine() {
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    public static CommandLine getInstance() {
        return sCommandLine.get();
    }

    @Nullable
    public static String[] getJavaSwitchesOrNull() {
        CommandLine commandLine = sCommandLine.get();
        if (commandLine != null) {
            return commandLine.getCommandLineArguments();
        }
        return null;
    }

    public static boolean isInitialized() {
        if (sCommandLine.get() != null) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public static void reset() {
        setInstance(null);
    }

    public static void init(@Nullable String[] strArr) {
        setInstance(new JavaCommandLine(strArr));
    }

    public static void initFromFile(String str) {
        String[] strArr;
        char[] readFileAsUtf8 = readFileAsUtf8(str);
        if (readFileAsUtf8 == null) {
            strArr = null;
        } else {
            strArr = tokenizeQuotedArguments(readFileAsUtf8);
        }
        init(strArr);
    }

    public static char[] readFileAsUtf8(String str) {
        File file = new File(str);
        try {
            FileReader fileReader = new FileReader(file);
            char[] cArr = new char[(int) file.length()];
            char[] copyOfRange = Arrays.copyOfRange(cArr, 0, fileReader.read(cArr));
            fileReader.close();
            return copyOfRange;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void setInstance(CommandLine commandLine) {
        CommandLine andSet = sCommandLine.getAndSet(commandLine);
        if (andSet != null) {
            andSet.destroy();
        }
    }

    @VisibleForTesting
    public static void setInstanceForTesting(CommandLine commandLine) {
        setInstance(commandLine);
    }

    @VisibleForTesting
    public static String[] tokenizeQuotedArguments(char[] cArr) {
        if (cArr.length <= 65536) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = null;
            char c = 0;
            for (char c2 : cArr) {
                if ((c == 0 && (c2 == '\'' || c2 == '\"')) || c2 == c) {
                    if (sb != null && sb.length() > 0 && sb.charAt(sb.length() - 1) == '\\') {
                        sb.setCharAt(sb.length() - 1, c2);
                    } else if (c == 0) {
                        c = c2;
                    } else {
                        c = 0;
                    }
                } else if (c == 0 && Character.isWhitespace(c2)) {
                    if (sb != null) {
                        arrayList.add(sb.toString());
                        sb = null;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(c2);
                }
            }
            if (sb != null) {
                if (c != 0) {
                    android.util.Log.w(TAG, "Unterminated quoted string: " + ((Object) sb));
                }
                arrayList.add(sb.toString());
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        throw new RuntimeException("Flags file too big: " + cArr.length);
    }

    public String getSwitchValue(String str, String str2) {
        String switchValue = getSwitchValue(str);
        if (!TextUtils.isEmpty(switchValue)) {
            return switchValue;
        }
        return str2;
    }
}
