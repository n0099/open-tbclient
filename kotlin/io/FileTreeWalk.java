package kotlin.io;

import com.alipay.sdk.util.e;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003$%&B\u001b\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"B\u008b\u0001\b\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n\u00128\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b!\u0010#J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u00002\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019RH\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "", "Ljava/io/File;", "iterator", "()Ljava/util/Iterator;", "", "depth", "maxDepth", "(I)Lkotlin/io/FileTreeWalk;", "Lkotlin/Function1;", "", "function", "onEnter", "(Lkotlin/Function1;)Lkotlin/io/FileTreeWalk;", "Lkotlin/Function2;", "Ljava/io/IOException;", "", "onFail", "(Lkotlin/Function2;)Lkotlin/io/FileTreeWalk;", "onLeave", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/io/FileWalkDirection;", "I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "f", "e", "Lkotlin/Function2;", "start", "Ljava/io/File;", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class FileTreeWalk implements Sequence<File> {
    public final FileWalkDirection direction;
    public final int maxDepth;
    public final Function1<File, Boolean> onEnter;
    public final Function2<File, IOException, Unit> onFail;
    public final Function1<File, Unit> onLeave;
    public final File start;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "kotlin/io/FileTreeWalk$WalkState", "Ljava/io/File;", "rootDir", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static abstract class DirectoryState extends WalkState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryState(File rootDir) {
            super(rootDir);
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
            if (_Assertions.ENABLED) {
                boolean isDirectory = rootDir.isDirectory();
                if (_Assertions.ENABLED && !isDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "", "computeNext", "()V", "Ljava/io/File;", PrefetchEvent.EVENT_DATA_ROOT_PATH, "Lkotlin/io/FileTreeWalk$DirectoryState;", "directoryState", "(Ljava/io/File;)Lkotlin/io/FileTreeWalk$DirectoryState;", "gotoNext", "()Ljava/io/File;", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "state", "Ljava/util/ArrayDeque;", "<init>", "(Lkotlin/io/FileTreeWalk;)V", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        public final ArrayDeque<WalkState> state = new ArrayDeque<>();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "kotlin/io/FileTreeWalk$DirectoryState", "Ljava/io/File;", ShaderParams.VALUE_TYPE_STEP, "()Ljava/io/File;", "", e.f1966a, "Z", "", "fileIndex", "I", "", "fileList", "[Ljava/io/File;", "rootVisited", "rootDir", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes10.dex */
        public final class BottomUpDirectoryState extends DirectoryState {
            public boolean failed;
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;
            public final /* synthetic */ FileTreeWalkIterator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.this$0 = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (!this.failed && this.fileList == null) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    if (function1 != null && !((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = getRoot().listFiles();
                    this.fileList = listFiles;
                    if (listFiles == null) {
                        Function2 function2 = FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            Unit unit = (Unit) function2.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.failed = true;
                    }
                }
                File[] fileArr = this.fileList;
                if (fileArr != null) {
                    int i2 = this.fileIndex;
                    Intrinsics.checkNotNull(fileArr);
                    if (i2 < fileArr.length) {
                        File[] fileArr2 = this.fileList;
                        Intrinsics.checkNotNull(fileArr2);
                        int i3 = this.fileIndex;
                        this.fileIndex = i3 + 1;
                        return fileArr2[i3];
                    }
                }
                if (this.rootVisited) {
                    Function1 function12 = FileTreeWalk.this.onLeave;
                    if (function12 != null) {
                        Unit unit2 = (Unit) function12.invoke(getRoot());
                    }
                    return null;
                }
                this.rootVisited = true;
                return getRoot();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "kotlin/io/FileTreeWalk$WalkState", "Ljava/io/File;", ShaderParams.VALUE_TYPE_STEP, "()Ljava/io/File;", "", "visited", "Z", "rootFile", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes10.dex */
        public final class SingleFileState extends WalkState {
            public final /* synthetic */ FileTreeWalkIterator this$0;
            public boolean visited;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingleFileState(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.checkNotNullParameter(rootFile, "rootFile");
                this.this$0 = fileTreeWalkIterator;
                if (_Assertions.ENABLED) {
                    boolean isFile = rootFile.isFile();
                    if (_Assertions.ENABLED && !isFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return getRoot();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "kotlin/io/FileTreeWalk$DirectoryState", "Ljava/io/File;", ShaderParams.VALUE_TYPE_STEP, "()Ljava/io/File;", "", "fileIndex", "I", "", "fileList", "[Ljava/io/File;", "", "rootVisited", "Z", "rootDir", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes10.dex */
        public final class TopDownDirectoryState extends DirectoryState {
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;
            public final /* synthetic */ FileTreeWalkIterator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.this$0 = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
                if (r0.length == 0) goto L30;
             */
            @Override // kotlin.io.FileTreeWalk.WalkState
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public File step() {
                Function2 function2;
                if (!this.rootVisited) {
                    Function1 function1 = FileTreeWalk.this.onEnter;
                    if (function1 == null || ((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        this.rootVisited = true;
                        return getRoot();
                    }
                    return null;
                }
                File[] fileArr = this.fileList;
                if (fileArr != null) {
                    int i2 = this.fileIndex;
                    Intrinsics.checkNotNull(fileArr);
                    if (i2 >= fileArr.length) {
                        Function1 function12 = FileTreeWalk.this.onLeave;
                        if (function12 != null) {
                            Unit unit = (Unit) function12.invoke(getRoot());
                        }
                        return null;
                    }
                }
                if (this.fileList == null) {
                    File[] listFiles = getRoot().listFiles();
                    this.fileList = listFiles;
                    if (listFiles == null && (function2 = FileTreeWalk.this.onFail) != null) {
                        Unit unit2 = (Unit) function2.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
                    }
                    File[] fileArr2 = this.fileList;
                    if (fileArr2 != null) {
                        Intrinsics.checkNotNull(fileArr2);
                    }
                    Function1 function13 = FileTreeWalk.this.onLeave;
                    if (function13 != null) {
                        Unit unit3 = (Unit) function13.invoke(getRoot());
                    }
                    return null;
                }
                File[] fileArr3 = this.fileList;
                Intrinsics.checkNotNull(fileArr3);
                int i3 = this.fileIndex;
                this.fileIndex = i3 + 1;
                return fileArr3[i3];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
        /* loaded from: classes10.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                $EnumSwitchMapping$0[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public FileTreeWalkIterator() {
            if (FileTreeWalk.this.start.isDirectory()) {
                this.state.push(directoryState(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                this.state.push(new SingleFileState(this, FileTreeWalk.this.start));
            } else {
                done();
            }
        }

        private final DirectoryState directoryState(File file) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[FileTreeWalk.this.direction.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return new BottomUpDirectoryState(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new TopDownDirectoryState(this, file);
        }

        private final File gotoNext() {
            File step;
            while (true) {
                WalkState peek = this.state.peek();
                if (peek == null) {
                    return null;
                }
                step = peek.step();
                if (step == null) {
                    this.state.pop();
                } else if (Intrinsics.areEqual(step, peek.getRoot()) || !step.isDirectory() || this.state.size() >= FileTreeWalk.this.maxDepth) {
                    break;
                } else {
                    this.state.push(directoryState(step));
                }
            }
            return step;
        }

        @Override // kotlin.collections.AbstractIterator
        public void computeNext() {
            File gotoNext = gotoNext();
            if (gotoNext != null) {
                setNext(gotoNext);
            } else {
                done();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\"\u0018\u0000B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "Ljava/io/File;", ShaderParams.VALUE_TYPE_STEP, "()Ljava/io/File;", PrefetchEvent.EVENT_DATA_ROOT_PATH, "Ljava/io/File;", "getRoot", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static abstract class WalkState {
        public final File root;

        public WalkState(File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            this.root = root;
        }

        public final File getRoot() {
            return this.root;
        }

        public abstract File step();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.io.File, java.lang.Boolean> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function12, Function2<? super File, ? super IOException, Unit> function2, int i2) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = function1;
        this.onLeave = function12;
        this.onFail = function2;
        this.maxDepth = i2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }

    public final FileTreeWalk maxDepth(int i2) {
        if (i2 > 0) {
            return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, i2);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i2 + IStringUtil.EXTENSION_SEPARATOR);
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.start, this.direction, function, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, function, this.onFail, this.maxDepth);
    }

    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i3 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i3 & 32) != 0 ? Integer.MAX_VALUE : i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(direction, "direction");
    }

    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}
