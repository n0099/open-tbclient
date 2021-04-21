package com.google.common.util.concurrent;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import d.h.c.a.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class CycleDetectingLockFactory {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f31281b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<c>> f31282c;

    /* renamed from: a  reason: collision with root package name */
    public final d f31283a;

    /* loaded from: classes6.dex */
    public final class CycleDetectingReentrantLock extends ReentrantLock implements b {
        public final c lockGraphNode;

        public /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z, a aVar) {
            this(cVar, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public c getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        public CycleDetectingReentrantLock(c cVar, boolean z) {
            super(z);
            n.p(cVar);
            this.lockGraphNode = cVar;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements b {
        public final c lockGraphNode;
        public final CycleDetectingReentrantReadLock readLock;
        public final CycleDetectingReentrantWriteLock writeLock;

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z, a aVar) {
            this(cVar, z);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public c getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        public CycleDetectingReentrantReadWriteLock(c cVar, boolean z) {
            super(z);
            this.readLock = new CycleDetectingReentrantReadLock(this);
            this.writeLock = new CycleDetectingReentrantWriteLock(this);
            n.p(cVar);
            this.lockGraphNode = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    /* loaded from: classes6.dex */
    public static class ExampleStackTrace extends IllegalStateException {
        public static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        public static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), c.class.getName());

        public ExampleStackTrace(c cVar, c cVar2) {
            super(cVar.d() + LoadErrorCode.TOKEN_NEXT + cVar2.d());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                if (e.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                    setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum Policies implements d {
        THROW { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies, com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies, com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f31281b.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies, com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
        public abstract /* synthetic */ void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);

        /* synthetic */ Policies(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        public final ExampleStackTrace conflictingStackTrace;

        public /* synthetic */ PotentialDeadlockException(c cVar, c cVar2, ExampleStackTrace exampleStackTrace, a aVar) {
            this(cVar, cVar2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(th.getMessage());
            }
            return sb.toString();
        }

        public PotentialDeadlockException(c cVar, c cVar2, ExampleStackTrace exampleStackTrace) {
            super(cVar, cVar2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends ThreadLocal<ArrayList<c>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<c> initialValue() {
            return Lists.l(3);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        c getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<c, ExampleStackTrace> f31284a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<c, PotentialDeadlockException> f31285b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31286c;

        public void a(d dVar, c cVar) {
            n.A(this != cVar, "Attempted to acquire multiple locks with the same rank %s", cVar.d());
            if (this.f31284a.containsKey(cVar)) {
                return;
            }
            PotentialDeadlockException potentialDeadlockException = this.f31285b.get(cVar);
            if (potentialDeadlockException != null) {
                dVar.handlePotentialDeadlock(new PotentialDeadlockException(cVar, this, potentialDeadlockException.getConflictingStackTrace(), null));
                return;
            }
            ExampleStackTrace c2 = cVar.c(this, Sets.e());
            if (c2 == null) {
                this.f31284a.put(cVar, new ExampleStackTrace(cVar, this));
                return;
            }
            PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(cVar, this, c2, null);
            this.f31285b.put(cVar, potentialDeadlockException2);
            dVar.handlePotentialDeadlock(potentialDeadlockException2);
        }

        public void b(d dVar, List<c> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a(dVar, list.get(i));
            }
        }

        public final ExampleStackTrace c(c cVar, Set<c> set) {
            if (set.add(this)) {
                ExampleStackTrace exampleStackTrace = this.f31284a.get(cVar);
                if (exampleStackTrace != null) {
                    return exampleStackTrace;
                }
                for (Map.Entry<c, ExampleStackTrace> entry : this.f31284a.entrySet()) {
                    c key = entry.getKey();
                    ExampleStackTrace c2 = key.c(cVar, set);
                    if (c2 != null) {
                        ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(key, this);
                        exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                        exampleStackTrace2.initCause(c2);
                        return exampleStackTrace2;
                    }
                }
                return null;
            }
            return null;
        }

        public String d() {
            return this.f31286c;
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    /* loaded from: classes6.dex */
    public static final class e<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    static {
        MapMaker mapMaker = new MapMaker();
        mapMaker.l();
        mapMaker.i();
        f31281b = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        f31282c = new a();
    }

    public static void e(b bVar) {
        if (bVar.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<c> arrayList = f31282c.get();
        c lockGraphNode = bVar.getLockGraphNode();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNode) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public final void a(b bVar) {
        if (bVar.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<c> arrayList = f31282c.get();
        c lockGraphNode = bVar.getLockGraphNode();
        lockGraphNode.b(this.f31283a, arrayList);
        arrayList.add(lockGraphNode);
    }

    /* loaded from: classes6.dex */
    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }
    }
}
